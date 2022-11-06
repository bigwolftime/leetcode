package leetcode;

/**
 * 设计 Goal 解析器
 * https://leetcode.cn/problems/goal-parser-interpretation/
 *
 * @author liuxin
 * @date 2022/11/6 1:08 PM
 */
public class Interpret {

    private static final char G = 'G';
    private static final char L_BRACKET = '(';
    private static final char R_BRACKET = ')';

    private static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < command.length()) {
            char c = command.charAt(idx);
            if (c == G) {
                sb.append(G);
                idx++;
            } else if (c == L_BRACKET) {

                if (command.charAt(idx + 1) == R_BRACKET) {
                    sb.append('o');
                    idx += 2;
                } else {
                    sb.append("al");
                    idx += 4;
                }

            }
        }


        return sb.toString();
    }


    public static void main(String[] args) {

    }

}
