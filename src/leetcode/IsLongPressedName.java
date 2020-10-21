package leetcode;

/**
 * 长按键入
 * https://leetcode-cn.com/problems/long-pressed-name/
 *
 * @author liuxin
 * @time 2020/10/21 9:52
 */
public class IsLongPressedName {

    private static boolean isLongPressedName(String name, String typed) {
        int p = 0, q = 0;
        char c;

        while (p < name.length() && q < typed.length()) {
            c = typed.charAt(q);

            if (c == name.charAt(p)) {
                p++;
            } else {
                if (q == 0) {
                    return false;
                } else if (typed.charAt(q) != typed.charAt(q - 1)) {
                    return false;
                }
            }

            q++;
        }

        if (p >= name.length() && q >= typed.length()) {
            return true;
        } else if (p >= name.length()) {
            c = name.charAt(p - 1);
            while (q < typed.length()) {
                if (typed.charAt(q) != c) {
                    return false;
                }
                q++;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.err.println(isLongPressedName("alex", "alexxr"));
    }

}
