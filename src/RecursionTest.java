public class RecursionTest {

    public static int equation(int input) {
        if (input == 0) {
            return 0;
        } else {
            return 2 * equation(input - 1) + input * input;
        }
    }

    public static void main(String[] args) {
        //int result = equation(4);

        //System.out.println("result = " + result);

        System.out.println("39 + 3");
        System.out.println(39 + 3);
        System.out.println("39" + 3);

    }

}
