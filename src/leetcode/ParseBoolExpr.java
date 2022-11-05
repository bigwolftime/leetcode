package leetcode;

import java.util.*;

/**
 * 解析布尔表达式
 * https://leetcode.cn/problems/parsing-a-boolean-expression/
 *
 * @author liuxin
 * @date 2022/11/5 10:17
 */
public class ParseBoolExpr {

    private static Stack<Character> STACK;

    private static final char L_BRACKET = '(';
    private static final char R_BRACKET = ')';

    private static final char T = 't';
    private static final char F = 'f';

    private static final char OP_OR = '|';
    private static final char OP_AND = '&';
    private static final char OP_NOT = '!';
    private static Set<Character> OP_SET;

    static {
        OP_SET = new HashSet<>();
        OP_SET.add(OP_OR);
        OP_SET.add(OP_AND);
        OP_SET.add(OP_NOT);
    }


    private static boolean parseBoolExpr(String expression) {
        STACK = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);
            if (OP_SET.contains(c)) {
                // op
                STACK.push(c);
            } else if (c == R_BRACKET) {
                // stack pop -> stack push -> stack pop ...
                calc();
            } else if (c == T || c == F || c == L_BRACKET) {
                STACK.push(c);
            }
        }

        return STACK.peek() == T;
    }


    private static void calc() {
        // get param
        List<Character> allParamList = getAllParam();
        char op = allParamList.get(allParamList.size() - 1);
        char res = ' ';

        if (op == OP_NOT) {
            res = allParamList.get(0) == T ? F : T;
        } else if (op == OP_AND) {
            res = allParamList.contains(F) ? F : T;
        } else if (op == OP_OR) {
            res = allParamList.contains(T) ? T : F;
        }

        // push result
        STACK.push(res);
    }

    private static List<Character> getAllParam() {
        List<Character> list = new ArrayList<>();
        while (!STACK.isEmpty() && (STACK.peek() == T || STACK.peek() == F)) {
            list.add(STACK.pop());
        }

        // remove left bracket
        STACK.pop();
        // remove op
        list.add(STACK.pop());

        return list;
    }


    public static void main(String[] args) {
        //String s = "|(&(t,f,t),!(t))";
        // String s = "&(|(f))";
        //String s = "!(f)";
        //String s = "|(f,t)";
        //String s ="&(t,f)";
        // String s = "|(&(t,f,t),!(t))";
        String s = "!(&(!(t),&(f),|(f)))";
        boolean b = parseBoolExpr(s);
        System.err.println(b);
    }

}
