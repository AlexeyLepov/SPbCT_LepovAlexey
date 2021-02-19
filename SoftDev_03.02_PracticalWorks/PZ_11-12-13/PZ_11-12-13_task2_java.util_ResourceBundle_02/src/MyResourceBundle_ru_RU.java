import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class MyResourceBundle_ru_RU extends ResourceBundle {
    Hashtable bundle = null;
    public MyResourceBundle_ru_RU() {
        bundle = new Hashtable();
        bundle.put("Bundle description","Набор ресурсов для русской локали");
        bundle.put("Behavior",new RussianBehavior());
    }
    public Enumeration getKeys() {
        return bundle.keys();
    }
    protected Object handleGetObject(String key) throws
            java.util.MissingResourceException {
        return bundle.get(key);
    }
}