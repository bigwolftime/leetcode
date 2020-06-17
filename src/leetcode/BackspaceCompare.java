package leetcode;

import java.util.Stack;

/**
 * @Author Liuxin
 * @Date 2019/5/10 16:15
 *
 * 比较含空格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 *
 * 用栈实现比较方便.
 */
public class BackspaceCompare {

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stackS.isEmpty()){
                    stackS.pop();
                }
            } else {
                stackS.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stackT.isEmpty()){
                    stackT.pop();
                }
            } else {
                stackT.push(T.charAt(i));
            }
        }

        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (!stackS.pop().equals(stackT.pop())) {
                return false;
            }
        }

        return stackS.isEmpty() && stackT.isEmpty();
    }

    public static void main(String[] args) {
        System.err.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
