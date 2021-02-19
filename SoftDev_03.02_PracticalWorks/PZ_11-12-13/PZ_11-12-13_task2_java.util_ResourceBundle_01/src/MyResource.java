import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class MyResource extends ResourceBundle {
    private Hashtable res = null;
    public MyResource() {
        res = new Hashtable();
        res.put("TestKey","English Variant");
    }
    public Enumeration getKeys() {
        return res.keys();
    }
    protected Object handleGetObject(String key) throws
            java.util.MissingResourceException {
        return res.get(key);
    }
}