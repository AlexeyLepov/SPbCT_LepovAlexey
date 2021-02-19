import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class MyResourceBundle_en_EN extends ResourceBundle {
    Hashtable bundle = null;
    public MyResourceBundle_en_EN() {
        bundle = new Hashtable();
        bundle.put("Bundle description","English resource set");
        bundle.put("Behavior",new EnglishBehavior());
    }
    public Enumeration getKeys() {
        return bundle.keys();
    }
    protected Object handleGetObject(String key) throws
            java.util.MissingResourceException {
        return bundle.get(key);
    }
}