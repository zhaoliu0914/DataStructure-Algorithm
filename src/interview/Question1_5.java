package interview;

public class Question1_5 {

    /**
     * 利用字符重复出现的次数，实现基本的字符串压缩功能。
     * 例如：字符串"aabcccccaaa"。
     * 若压缩后的字符串没有变短，则返回原来的字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        String inputs = "aabcccccaaa";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inputs.charAt(0));
        char lastChar = inputs.charAt(0);
        int lastCharCount = 1;
        char currentChar;
        for (int i = 1; i < inputs.length(); i++) {
            currentChar = inputs.charAt(i);
            if (currentChar == lastChar) {
                lastCharCount++;
            } else {
                stringBuilder.append(lastCharCount);
                stringBuilder.append(currentChar);

                lastChar = currentChar;
                lastCharCount = 1;
            }
        }
        stringBuilder.append(lastCharCount);

        System.out.println(stringBuilder.toString());
    }
}
