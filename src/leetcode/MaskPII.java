package leetcode;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * 隐藏个人信息
 * https://leetcode.cn/problems/masking-personal-information/
 *
 * @author liuxin
 * @date 2022/11/1 17:15
 */
public class MaskPII {

    private static final String AT = "@";
    private static final Set<Character> TELEPHONE_SEPARATOR_SET = new HashSet<>();

    static {
        TELEPHONE_SEPARATOR_SET.add('+');
        TELEPHONE_SEPARATOR_SET.add('-');
        TELEPHONE_SEPARATOR_SET.add('(');
        TELEPHONE_SEPARATOR_SET.add(')');
        TELEPHONE_SEPARATOR_SET.add(' ');
    }


    private static String maskPII(String s) {
        return isEmail(s) ? maskEmail(s) : maskTelephone(s);
    }

    private static String maskEmail(String s) {
        StringBuilder sb = new StringBuilder();

        Pair<String, Integer> namePair = parseEmailName(s);
        char firstC = toLowerCaseSingle(namePair.getKey().substring(0, 1));
        char lastC = toLowerCaseSingle(namePair.getKey().substring(namePair.getKey().length() - 1));
        sb.append(firstC).append("*****").append(lastC).append(AT);

        sb.append(s.substring(namePair.getValue() + 1).toLowerCase());
        return sb.toString();
    }

    private static Pair<String, Integer> parseEmailName(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '@') {
                return new Pair<>(sb.toString(), i);
            }

            sb.append(c);
        }

        return new Pair<>(sb.toString(), -1);
    }

    private static String maskTelephone(String s) {
        s = trimTelephone(s);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.insert(0, s.charAt(s.length() - i - 1));
        }
        sb.insert(0, "***-***-");

        if (s.length() == 10) {
            return sb.toString();
        }

        if (s.length() == 11) {
            sb.insert(0, "+*-");
        } else if (s.length() == 12) {
            sb.insert(0, "+**-");
        } else if (s.length() == 13) {
            sb.insert(0, "+***-");
        }

        return sb.toString();
    }

    private static String trimTelephone(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (TELEPHONE_SEPARATOR_SET.contains(c)) {
                continue;
            }

            sb.append(c);
        }

        return sb.toString();
    }

    private static char toLowerCaseSingle(String s) {
        char c = s.charAt(0);
        if (c >= 'a' && c <= 'z') {
            return c;
        }

        return (char) (c + 32);
    }

    private static boolean isEmail(String s) {
        return s.contains(AT);
    }


    public static void main(String[] args) {
        String s = maskTelephone("15247656141");
        System.err.println(s);
    }

}
