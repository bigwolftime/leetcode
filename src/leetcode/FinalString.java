package leetcode;

/**
 * 故障键盘<br/>
 * <a href="https://leetcode.cn/problems/faulty-keyboard">...</a>
 *
 * @author liuxin
 * @date 2024/4/1 10:21
 */
public class FinalString {

    private static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                revert(sb);
                continue;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    private static void revert(StringBuilder sb) {
        int p = 0, q = sb.length() - 1;
        while (p < q) {
            char c = sb.charAt(p);
            sb.setCharAt(p, sb.charAt(q));
            sb.setCharAt(q, c);
            p++;
            q--;
        }
    }


    public static void main(String[] args) {

    }
}
