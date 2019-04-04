/**
 * @Author Liuxin
 * @Date 2019/4/4 9:50
 *
 * 密钥格式化
 * https://leetcode-cn.com/problems/license-key-formatting/submissions/
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();

        int index = S.length() - 1;
        while (index >= 0 && S.charAt(index) == '-'){
            index--;
        }

        int internal = K;
        while (index >= 0){
            while (internal > 0 && index >= 0){
                if (S.charAt(index) != '-'){
                    res.insert(0, toUpperCase(S.charAt(index)));
                    internal--;
                }
                index--;
            }
            if (res.charAt(0) != '-'){
                res.insert(0, '-');
            }

            internal = K;
        }

        return res.length() > 0 ? res.substring(1, res.length()) : res.toString();
    }

    private static char toUpperCase(char c){
        if (c >= 'a' && c <= 'z'){
            return (char)(c - 32);
        }
        return c;
    }

    public static void main(String[] args) {
        System.err.println(licenseKeyFormatting("2-5g-3-J", 2));
    }
}
