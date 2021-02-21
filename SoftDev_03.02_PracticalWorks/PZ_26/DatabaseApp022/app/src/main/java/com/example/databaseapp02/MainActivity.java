package com.example.databaseapp02;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements OnClickListener {

    final String LOG_TAG = "myLogs";

    String model[] = { "Intel Core i7-9700F", "Intel Celeron G5900", "AMD Athlon 3000G", "AMD Ryzen 3 3100", "AMD Ryzen 5 2600",
            "AMD Ryzen 5 3600", "AMD Ryzen 7 2700", "AMD Ryzen 7 3800X", "Intel Core i3-9100F", "Intel Core i5-9400F" };
    int price[] = { 6599, 5299, 10399, 12399, 2189, 5699, 7399, 6399, 5399, 3499 };
    String brand[] = { "Intel", "Intel", "AMD", "AMD", "AMD",
            "AMD", "AMD", "AMD", "Intel", "Intel" };

    Button btnAll, btnFunc, btnPrice, btnSort, btnGroup, btnHaving;
    EditText etFunc, etPrice, etBrandPrice;
    RadioGroup rgSort;

    DBHelper dbHelper;
    SQLiteDatabase db;

    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAll = (Button) findViewById(R.id.btnAll);
        btnAll.setOnClickListener(this);

        btnFunc = (Button) findViewById(R.id.btnFunc);
        btnFunc.setOnClickListener(this);

        btnPrice = (Button) findViewById(R.id.btnPrice);
        btnPrice.setOnClickListener(this);

        btnSort = (Button) findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);

        btnGroup = (Button) findViewById(R.id.btnGroup);
        btnGroup.setOnClickListener(this);

        btnHaving = (Button) findViewById(R.id.btnHaving);
        btnHaving.setOnClickListener(this);

        etFunc = (EditText) findViewById(R.id.etFunc);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etBrandPrice = (EditText) findViewById(R.id.etBrandPrice);

        rgSort = (RadioGroup) findViewById(R.id.rgSort);

        dbHelper = new DBHelper(this);
        // подключаемся к базе
        db = dbHelper.getWritableDatabase();

        // проверка существования записей
        Cursor c = db.query("mytable", null, null, null, null, null, null);
        if (c.getCount() == 0) {
            ContentValues cv = new ContentValues();
            // заполним таблицу
            for (int i = 0; i < 10; i++) {
                cv.put("model", model[i]);
                cv.put("price", price[i]);
                cv.put("brand", brand[i]);
                Log.d(LOG_TAG, "id = " + db.insert("mytable", null, cv));
            }
        }
        c.close();
        dbHelper.close();
        // эмулируем нажатие кнопки btnAll
        onClick(btnAll);

    }

    public void onClick(View v) {

        // подключаемся к базе
        db = dbHelper.getWritableDatabase();

        // данные с экрана
        String sFunc = etFunc.getText().toString();
        String sPrice = etPrice.getText().toString();
        String sBrandPrice = etBrandPrice.getText().toString();

        // переменные для query
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        // курсор
        Cursor c = null;

        // определяем нажатую кнопку
        switch (v.getId()) {
            // Все записи
            case R.id.btnAll:
                Log.d(LOG_TAG, "--- Все записи ---");
                c = db.query("mytable", null, null, null, null, null, null);
                break;
            // Функция
            case R.id.btnFunc:
                Log.d(LOG_TAG, "--- Функция " + sFunc + " ---");
                columns = new String[] { sFunc };
                c = db.query("mytable", columns, null, null, null, null, null);
                break;
            // Население больше, чем
            case R.id.btnPrice:
                Log.d(LOG_TAG, "--- Цена больше " + sPrice + " ---");
                selection = "price > ?";
                selectionArgs = new String[] { sPrice };
                c = db.query("mytable", null, selection, selectionArgs, null, null,
                        null);
                break;
            // Население по региону
            case R.id.btnGroup:
                Log.d(LOG_TAG, "--- Цена по бренду ---");
                columns = new String[] { "brand", "sum(price) as price" };
                groupBy = "brand";
                c = db.query("mytable", columns, null, null, groupBy, null, null);
                break;
            // Население по региону больше чем
            case R.id.btnHaving:
                Log.d(LOG_TAG, "--- Цена по бредну больше " + sBrandPrice
                        + " ---");
                columns = new String[] { "brand", "sum(price) as price" };
                groupBy = "brand";
                having = "sum(price) > " + sBrandPrice;
                c = db.query("mytable", columns, null, null, groupBy, having, null);
                break;
            // Сортировка
            case R.id.btnSort:
                // сортировка по
                switch (rgSort.getCheckedRadioButtonId()) {
                    // наименование
                    case R.id.rModel:
                        Log.d(LOG_TAG, "--- Сортировка по наименованию модели ---");
                        orderBy = "model";
                        break;
                    // население
                    case R.id.rPrice:
                        Log.d(LOG_TAG, "--- Сортировка по цене ---");
                        orderBy = "price";
                        break;
                    // регион
                    case R.id.rBrand:
                        Log.d(LOG_TAG, "--- Сортировка по бренду-производителю ---");
                        orderBy = "brand";
                        break;
                }
                c = db.query("mytable", null, null, null, null, null, orderBy);
                break;
        }

        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + ": "
                                + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(LOG_TAG, str);

                } while (c.moveToNext());
            }
            c.close();
        } else
            Log.d(LOG_TAG, "Cursor is null");

        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement," + "model text,"
                    + "price integer," + "brand text" + ");");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}