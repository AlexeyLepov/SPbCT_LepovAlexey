public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String s = "prefix !";
        System.out.println(s);
        s = s.trim();
        System.out.println(s);
        s = s.concat(" suffix");
        System.out.println(s);
    }
}