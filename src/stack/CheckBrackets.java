package stack;

public class CheckBrackets {
    private static String openParenthesis = "(";
    private static String closeParenthesis = ")";
    private static String openSquareBrackets = "[";
    private static String closeSquareBrackets = "]";
    private static String openBrace = "{";
    private static String closeBrace = "}";
    private static String brackets = ")]}";

    public static void main(String[] args) {

        String tests = "{([({})])}";

        MyStack<Character> stack = new MyStack<Character>();

        char[] chars = tests.toCharArray();

        boolean matchedPair = false;
        Character currentChar;
        Character topChar;
        for (int i = 0; i < chars.length; i++) {
            currentChar = chars[i];

            if (brackets.contains(currentChar.toString())) {
                if (stack.isEmpty()) {
                    System.out.println("Error");
                }

                matchedPair = false;
                topChar = stack.top();

                if (closeParenthesis.equals(currentChar.toString())) {
                    if (openParenthesis.equals(topChar.toString())) {
                        matchedPair = true;
                    }

                } else if (closeSquareBrackets.equals(currentChar.toString())) {
                    if (openSquareBrackets.equals(topChar.toString())) {
                        matchedPair = true;
                    }

                } else if (closeBrace.equals(currentChar.toString())) {
                    if (openBrace.equals(topChar.toString())) {
                        matchedPair = true;
                    }

                }

                if (matchedPair == false) {
                    System.out.println("Error");

                    stack.push(topChar);
                }
            } else {
                stack.push(currentChar);
            }

        }

        if (!stack.isEmpty()) {
            System.out.println("Error");
        }

    }

}
