package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 删除子串后的字符串最小长度
 * https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/
 *
 * @author liuxin
 * @date 2023/9/15 17:43
 */
public class MinLength {

    private static int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                // empty -> push
                stack.push(c);
            } else if (c == 'D' && stack.peek() == 'C') {
                // judge stack peek is char C? -> match and pop stack
                stack.pop();
            } else if (c == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }


    public static void main(String[] args) {

    }

}
