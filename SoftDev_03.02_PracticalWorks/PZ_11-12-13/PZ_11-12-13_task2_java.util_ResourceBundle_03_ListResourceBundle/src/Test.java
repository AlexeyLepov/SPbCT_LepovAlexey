import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

public class Test {
    public Test() {
    }
    public static void main(String[] args) {
        Test test = new Test();
        ResourceBundle rb = ResourceBundle.getBundle("MyResource", Locale.getDefault());
        Vector v = (Vector)rb.getObject("VectorKey");
        Iterator it = v.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}