import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
    public Test() {
    }
    public static void main(String[] args) {
        Test test = new Test();
        ResourceBundle rb = ResourceBundle.getBundle("MyResource",Locale.getDefault());
        System.out.println(rb.getString("TestKey"));
        rb = ResourceBundle.getBundle("MyResource", new Locale("ru","RU"));
        System.out.println(rb.getString("TestKey"));
    }
}