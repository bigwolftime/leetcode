package leetcode;

import java.util.Stack;

/**
 * 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * 重在思路... 开始并没有想到用栈存储索引, 而是存储字符(左括号 or 右括号), 所以没法彻底解决问题.
 *
 * @author liuxin
 * @date 2020/7/4 7:45
 */
public class LongestValidParentheses {

    private static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int curLen = 0, maxLen = 0;
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (c == ')' && (stack.peek() == -1 || s.charAt(stack.peek()) == ')')) {
                // 遇到了 无法匹配的 右括号
                stack.pop();
                stack.push(i);
            } else {
                if (c == '(') {
                    // 左括号 push 即可
                    stack.push(i);
                    continue;
                }

                // 剩下的情况: 匹配

                // 弹出最上面的 左括号
                stack.pop();

                curLen = i - stack.peek();
                maxLen = Math.max(maxLen, curLen);
            }

        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.err.println(longestValidParentheses(")()())"));
    }

}
