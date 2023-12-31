public class TestScoping1 {
    static int x = 3;

    static int foo() {
        return x++;
    }

    static int bar(int x) {
        return foo();
    }

    public static void main(String[] args) {

        int y = x + bar(5);

        System.out.println(y);
    }
}
