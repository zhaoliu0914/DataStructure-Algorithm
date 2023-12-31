public class TestScoping {
    public static int i;

    public static void function2() {
        i = 1;
    }

    public static void function1() {
        int i = 3;
        function2();
        System.out.println("execute main(), after function2() i = " + i);
    }

    public static void main(String[] args) {
        i = 2;

        System.out.println("execute main(), i = " + i);

        function1();

        System.out.println("execute main(), after function1() i = " + i);
    }

}
