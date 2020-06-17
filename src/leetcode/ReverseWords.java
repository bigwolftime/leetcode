package leetcode;

import java.util.Stack;

/**
 * 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * 空间复杂度可优化
 */
public class ReverseWords {

    private static String reverseWords(String s) {
        int index = 0;
        Stack<String> stack = new Stack<>();

        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                // start a word
                StringBuilder sb = new StringBuilder();
                char c;
                while (index < s.length() && (c = s.charAt(index)) != ' ') {
                    sb.append(c);
                    index++;
                }
                stack.push(sb.toString());
                // end word
            }

            index++;
        }

        StringBuilder resBuilder = new StringBuilder();
        boolean stackNotNull = !stack.isEmpty();
        while (!stack.isEmpty()) {
            resBuilder.append(" ").append(stack.pop());
        }
        if (stackNotNull) {
            resBuilder.deleteCharAt(0);
        }

        return resBuilder.toString();
    }

    public static void main(String[] args) {

    }

}
