package stack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static String plus = "+";
    private static String minus = "-";
    private static String product = "*";
    private static String division = "/";

    private static String POP_OPERATIONS = "(+-";
    private static String FOUR_OPERATIONS = "+-*/";

    private static String OPEN_PARENTHESIS = "(";
    private static String CLOSE_PARENTHESIS = ")";

    public static List<String> convertEquationToArray(String equation) {
        if (equation == null || equation.isBlank()) {
            return null;
        }

        List<String> resultList = new ArrayList<>();

        char[] chars = equation.toCharArray();

        char temp;
        String number = "";
        for (int i = 0; i < chars.length; i++) {
            temp = chars[i];

            if (Character.isDigit(temp)) {
                number = number + temp;
            } else {
                if (!number.isBlank()) {
                    resultList.add(number);
                }
                resultList.add(String.valueOf(temp));

                number = "";
            }
        }
        resultList.add(number);

        return resultList;
    }

    public static String transformInfixToPostfix(String infixEquation) {
        if (infixEquation == null || infixEquation.isBlank()) {
            return null;
        }

        List<String> contentList = convertEquationToArray(infixEquation);

        if (contentList == null || contentList.size() == 0) {
            return null;
        }

        String result = "";
        MyStack<String> stack = new MyStack<>();
        String stackStr;

        for (String currentStr : contentList) {
            if (Character.isDigit(currentStr.charAt(0))) {
                result = result + currentStr + " ";

            } else if (OPEN_PARENTHESIS.equals(currentStr)) {
                stack.push(currentStr);

            } else if (CLOSE_PARENTHESIS.equals(currentStr)) {
                stackStr = stack.top();

                result = result + stackStr + " ";

                while (!OPEN_PARENTHESIS.equals(stackStr)) {
                    stackStr = stack.top();

                    if (!OPEN_PARENTHESIS.equals(stackStr) && !CLOSE_PARENTHESIS.equals(stackStr)) {
                        result = result + stackStr + " ";
                    }
                }

            } else if (product.equals(currentStr) || division.equals(currentStr)) {
                stack.push(currentStr);

            } else if (plus.equals(currentStr) || minus.equals(currentStr)) {
                if (stack.isEmpty()) {
                    stack.push(currentStr);
                } else {
                    stackStr = stack.top();

                    if (OPEN_PARENTHESIS.equals(stackStr)) {
                        stack.push(stackStr);
                        stack.push(currentStr);
                    } else {

                        result = result + stackStr + " ";

                        while (!POP_OPERATIONS.contains(stackStr)) {
                            stackStr = stack.top();

                            if (!OPEN_PARENTHESIS.equals(stackStr) && !CLOSE_PARENTHESIS.equals(stackStr)) {
                                result = result + stackStr + " ";
                            }
                        }
                        if (OPEN_PARENTHESIS.equals(stackStr)) {
                            stack.push(stackStr);
                        }

                        stack.push(currentStr);
                    }
                }
            }

        }

        if (!stack.isEmpty()) {
            String tempStr = stack.top();
            result = result + tempStr + " ";

            while (!stack.isEmpty()) {
                tempStr = stack.top();
                result = result + tempStr + " ";
            }
        }


        return result.strip();
    }

    public static String postfixEquation(String equation) {
        if (equation == null || equation.isBlank()) {
            return "";
        }

        MyStack<String> stack = new MyStack<>();

        String[] strArrays = equation.split(" ");

        String currentStr;
        String firstNumberStr;
        String secondNumberStr;
        BigDecimal firstNumber;
        BigDecimal secondNumber;
        BigDecimal tempResult;
        for (int i = 0; i < strArrays.length; i++) {
            currentStr = strArrays[i];

            if (Character.isDigit(currentStr.charAt(0))) {
                stack.push(currentStr);

            } else if (FOUR_OPERATIONS.contains(currentStr)) {
                firstNumberStr = stack.top();
                secondNumberStr = stack.top();

                firstNumber = new BigDecimal(firstNumberStr);
                secondNumber = new BigDecimal(secondNumberStr);

                if (plus.equals(currentStr)) {
                    tempResult = firstNumber.add(secondNumber);

                    stack.push(tempResult.toString());
                } else if (minus.equals(currentStr)) {
                    tempResult = secondNumber.subtract(firstNumber);

                    stack.push(tempResult.toString());
                } else if (product.equals(currentStr)) {
                    tempResult = firstNumber.multiply(secondNumber);

                    stack.push(tempResult.toString());
                } else if (division.equals(currentStr)) {
                    tempResult = secondNumber.divide(firstNumber, RoundingMode.HALF_UP);

                    stack.push(tempResult.toString());
                }

            }

        }

        String result = stack.top();

        return result;
    }

    public static void main(String[] args) {
        String equation = "56+32*64+(21*40+64)*13";

        String postfix = transformInfixToPostfix(equation);
        System.out.println("postfix = " + postfix);

        String result = postfixEquation(postfix);

        System.out.println("result = " + result);


    }

}
