package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 * https://leetcode.cn/problems/letter-case-permutation/
 *
 * 回溯
 *
 * @author liuxin
 * @date 2022/10/30 5:21 PM
 */
public class LetterCasePermutation {

    private static List<String> LIST;

    private static List<String> letterCasePermutation(String s) {
        LIST = new ArrayList<>();

        dfs(new StringBuilder(), s, 0);
        return LIST;
    }


    private static void dfs(StringBuilder sb, String s, int idx) {
        if (idx == s.length()) {
            LIST.add(sb.toString());
            return;
        }

        char c = s.charAt(idx);
        if (isDigital(c)) {
            sb.append(c);
            dfs(sb, s, idx + 1);
            return;
        }

        StringBuilder tempSb = new StringBuilder(sb);
        tempSb.append(c);
        dfs(tempSb, s, idx + 1);

        if (isUpperCase(c)) {
            c = toLowerCase(c);
        } else {
            c = toUpperCase(c);
        }
        sb.append(c);
        dfs(sb, s, idx + 1);
    }

    private static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static char toUpperCase(char c) {
        return (char) (c - 32);
    }

    private static char toLowerCase(char c) {
        return (char) (c + 32);
    }


    public static void main(String[] args) {
        List<String> a1b2 = letterCasePermutation("a1b2");
        System.err.println(a1b2);
    }

}
