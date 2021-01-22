package leetcode;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {

    private static int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (String s : tokens) {
            if (isOp(s)) {
                int num2 = stack.pop(), num1 = stack.pop();

                res = op(num1, num2, s);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return res;
    }

    private static boolean isOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static int op(int num1, int num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
