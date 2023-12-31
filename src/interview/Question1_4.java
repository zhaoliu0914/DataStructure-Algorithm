package interview;

public class Question1_4 {

    /**
     * 讲字符串中的空格全部替换为 "%20"
     * <p>
     * 例: 输入 "Mr John Smith"
     * #   输出 "Mr%20John%20Smith"
     *
     * @param args
     */
    public static void main(String[] args) {
        String inputs = "Mr John Smith";

        int spaceCount = 0;
        for (int i = 0; i < inputs.length(); i++) {
            char tempChar = inputs.charAt(i);
            if (tempChar == ' ') {
                spaceCount++;
            }
        }

        int newLength = inputs.length() + spaceCount * 2;

        char[] charArray = new char[newLength];
        System.arraycopy(inputs.toCharArray(), 0, charArray, 0, inputs.length());

        for (int i = inputs.length() - 1; i >= 0; i--) {
            char tempChar = inputs.charAt(i);
            if (tempChar == ' ') {
                charArray[newLength - 1] = '0';
                charArray[newLength - 2] = '2';
                charArray[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                charArray[newLength - 1] = tempChar;
                newLength--;
            }
        }

        System.out.println(charArray);

    }
}
