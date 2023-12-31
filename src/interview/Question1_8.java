package interview;

import java.util.Arrays;

/**
 * 已存在方法 isSubstring, 可检查一个单词是否为其他字符串的子串。
 * 两个参数字符串 s1 和 s2, 检查 s2 是否为 s1 旋转而来，
 * 要求只能调用一次 isSubstring.
 * 例：waterbottle 是 erbottlewat 旋转后的字符串
 */
public class Question1_8 {

    /**
     * @param
     * @return
     */
    private static boolean isSubstring(String str1, String str2) {
        if (str1.isBlank() || str2.isBlank()) {
            return false;
        }

        if (str1.contains(str2) || str2.contains(str1)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "erbottlewat";
        String s2 = "waterbottle";

        String combinationStr = s1 + s1;
        System.out.println("combinationStr = " + combinationStr);

        boolean result = isSubstring(combinationStr, s2);

        System.out.println(result);
    }

}
