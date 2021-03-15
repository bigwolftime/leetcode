package leetcode;

/**
 * 删除字符串中的所有相邻重复项
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class removeDuplicatesStr {

    private static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                // 栈空 || 栈顶元素 != c
                sb.append(c);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
