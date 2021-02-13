import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class MyResource_ru_RU extends ResourceBundle {
    private Hashtable res = null;
    public MyResource_ru_RU() {
        res = new Hashtable();
        res.put("TestKey","Русский вариант");
    }
    public Enumeration getKeys() {
        return res.keys();
    }
    protected Object handleGetObject(String key)
            throws java.util.MissingResourceException {
        return res.get(key);
    }
}