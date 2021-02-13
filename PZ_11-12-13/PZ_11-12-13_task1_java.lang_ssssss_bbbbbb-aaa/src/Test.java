public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        String s = new String("ssssss");
        StringBuffer sb =
                new StringBuffer("bbbbbb");
        s.concat("-aaa");
        sb.append("-aaa");
        System.out.println(s);
        System.out.println(sb);
    }
}