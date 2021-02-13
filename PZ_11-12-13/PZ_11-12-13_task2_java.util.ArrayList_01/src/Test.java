import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List l = Collections.synchronizedList(new ArrayList(...));
public class Test {
    public Test() {
    }
    public static void main(String[] args) {
        Test t = new Test();
        ArrayList al = new ArrayList();
        al.add("First element");
        al.add("Second element");
        al.add("Third element");
        Iterator it = al.iterator();
        while(it.hasNext()) {
            System.out.println((String)it.next());
        }
        System.out.println("\n");
        al.add(2,"Insertion");
        it = al.iterator();
        while(it.hasNext()){
            System.out.println((String)it.next());
        }
    }
}