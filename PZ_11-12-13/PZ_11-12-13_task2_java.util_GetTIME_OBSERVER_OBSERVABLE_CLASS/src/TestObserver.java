public class TestObserver implements java.util.Observer {
    private String name = "";

    public TestObserver(String name) {
        this.name = name;
    }
    public void update(java.util.Observable o,Object arg) {
        String str = "Called update of " + name;
        str += " from " + ((TestObservable)o).getName();
        str += " with argument " + (String)arg;
        System.out.println(str);
    }
}