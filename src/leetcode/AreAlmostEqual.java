package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 仅执行一次字符串交换能否使两个字符串相等
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
 *
 * @author liuxin
 * @date 2022/10/11 09:32
 */
public class AreAlmostEqual {

    private static final int MAX_DIFF_COUNT = 4;

    private static boolean areAlmostEqual(String s1, String s2) {
        List<Character> diffList = findDiff(s1, s2);

        if (diffList.isEmpty()) {
            return true;
        }

        if (diffList.size() > MAX_DIFF_COUNT) {
            return false;
        }

        int i = 0, j = diffList.size() - 1;
        while (i < j) {
            if (diffList.get(i).equals(diffList.get(j))) {
                i++;
                j--;
                continue;
            }

            return false;
        }

        return true;
    }

    private static List<Character> findDiff(String s1, String s2) {
        int i = 0;
        List<Character> list = new ArrayList<>();

        while (i < s1.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 == c2) {
                i++;
                continue;
            }

            list.add(c1);
            list.add(c2);

            if (list.size() > MAX_DIFF_COUNT) {
                break;
            }

            i++;
        }

        return list;
    }

    public static void main(String[] args) {
        areAlmostEqual("bank", "kanb");
    }

}
