package com.example.helloandroidworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView headerView = (TextView) findViewById(R.id.selectedMenuItem);
        switch(id){
            case R.id.menu_image:
                setContentView(R.layout.activity_image);
                return true;
            case R.id.menu_anim:
                setContentView(R.layout.activity_animation);
                return true;
            case R.id.menu_localize:
                setContentView(R.layout.activity_main);
                return true;
            case R.id.menu_quit:
                System.exit(0);
                return true;
        }
        //headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

}