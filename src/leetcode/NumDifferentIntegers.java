package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中不同整数的数目
 * https://leetcode.cn/problems/number-of-different-integers-in-a-string/
 *
 * @author liuxin
 * @date 2022/12/6 2:56 PM
 */
public class NumDifferentIntegers {

    private static int numDifferentIntegers(String word) {
        Set<String> numSet = new HashSet<>();

        StringBuilder sb = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (isDigital(c)) {
                // is digital

                if (sb == null) {
                    sb = new StringBuilder();
                }

                if (c == '0' && sb.length() == 0) {
                    continue;
                }

                sb.append(c);
            } else {
                // not digital
                if (sb != null) {
                    numSet.add(sb.toString());
                }

                sb = null;
            }
        }

        if (sb != null) {
            numSet.add(sb.toString());
        }


        return numSet.size();
    }

    private static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }


    public static void main(String[] args) {
        numDifferentIntegers("j000dk000s");
    }

}
