import java.util.StringTokenizer;

public class Test {

    public Test() {
    }
    public static void main(String[] args) {
        Test test = new Test();
        String toParse =
                "word1;word2;word3;word4";
        StringTokenizer st =
                new StringTokenizer(toParse,";");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}