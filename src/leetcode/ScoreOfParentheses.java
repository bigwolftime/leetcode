package leetcode;

import java.util.*;

/**
 * 括号的分数
 * https://leetcode.cn/problems/score-of-parentheses/
 *
 * 栈 条件比较多，头疼
 *
 * @author liuxin
 * @date 2022/10/9 09:54
 */
public class ScoreOfParentheses {

    private static final char L_PARENTHESIS_C = '(';
    private static final char R_PARENTHESIS_C = ')';
    private static final String L_PARENTHESIS = "(";
    private static final String R_PARENTHESIS = ")";
    private static final String OP_ADD = "+";
    private static final String OP_MULTI = "*";

    private static int scoreOfParentheses(String s) {
        Deque<String> deque = new ArrayDeque<>();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == L_PARENTHESIS_C) {

                if (deque.isEmpty()) {
                    // ...
                } else if (deque.peek().equals(L_PARENTHESIS)) {
                    deque.push(OP_MULTI);
                } else if (isDigital(deque.peek())) {
                    deque.push(OP_ADD);
                }
                deque.push(L_PARENTHESIS);

            } else if (c == R_PARENTHESIS_C) {

                if (deque.peek().equals(L_PARENTHESIS)) {
                    deque.pop();
                    deque.push("1");
                } else if (isDigital(deque.peek())) {
                    op(deque);
                }

                while (canRecursive(deque)) {
                    opRecursive(deque);
                }

            }

            i++;
        }

        return Integer.parseInt(deque.pop());
    }

    private static boolean isDigital(String s) {
        boolean isSymbol = s.equals(L_PARENTHESIS) || s.equals(R_PARENTHESIS) || s.equals(OP_MULTI) || s.equals(OP_ADD);
        return !isSymbol;
    }

    private static boolean canRecursive(Deque<String> deque) {
        if (deque.size() < 3 || !isDigital(deque.peek())) {
            return false;
        }

        String peek1 = deque.pop();
        String peek2 = deque.pop();
        boolean canRecursive = isDigital(deque.peek());

        deque.push(peek2);
        deque.push(peek1);

        return canRecursive;
    }

    private static void op(Deque<String> deque) {
        int result = 0;
        int param = Integer.parseInt(deque.pop());
        String op = deque.pop();
        if (op.equals(OP_MULTI)) {
            result = 2 * param;
        } else if (op.equals(OP_ADD)) {
            result = param + 1;
        }

        // pop L_PARENTHESIS
        deque.pop();
        deque.push(String.valueOf(result));
    }

    private static void opRecursive(Deque<String> deque) {
        int result = 0;
        int param1 = Integer.parseInt(deque.pop());
        String op = deque.pop();
        int param2 = Integer.parseInt(deque.pop());
        if (op.equals(OP_MULTI)) {
            result = param1 * param2;
        } else if (op.equals(OP_ADD)) {
            result = param1 + param2;
        }

        deque.push(String.valueOf(result));
    }

    public static void main(String[] args) {
        //String s = "()";
        // 1

        //String s = "(())";
        // 2

        //String s = "()()";
        // 2

        //String s = "(()(()))";
        // 6

        String s = "()()(())()";

        int i = scoreOfParentheses(s);
        System.err.println(i);
    }

}
