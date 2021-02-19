import java.util.Locale;
import java.util.ResourceBundle;

public class Using {
    public Using() {
    }

    public static void main(String[] args) {
        Using u = new Using();
        ResourceBundle rb =
                ResourceBundle.getBundle("MyResourceBundle", Locale.getDefault());
        System.out.println((String) rb.getObject("Bundle description"));
        Behavior be = (Behavior) rb.getObject("Behavior");
        System.out.println(be.getBehavior());
        System.out.println(be.getCapital());
        rb = ResourceBundle.getBundle("MyResourceBundle", new Locale("en", "EN"));
        System.out.println((String) rb.getObject("Bundle description"));
        be = (Behavior) rb.getObject("Behavior");
        System.out.println(be.getBehavior());
        System.out.println(be.getCapital());
    }
}