import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class MyResourceBundle extends ResourceBundle {
    Hashtable bundle = null;
    public MyResourceBundle() {
        bundle = new Hashtable();
        bundle.put("Bundle description","Default resource bundle");
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