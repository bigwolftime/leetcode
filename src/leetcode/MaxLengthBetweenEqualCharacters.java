package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个相同字符串之间的最长子字符串
 * https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters/
 *
 * @author liuxin
 * @date 2020/10/18 19:08
 */
public class MaxLengthBetweenEqualCharacters {

    private static int maxLengthBetweenEqualCharacters(String s) {
        List<Integer>[] arr = new List[26];
        char c;
        List<Integer> list;
        int maxLen = -1;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            list = arr[c - 97];

            if (list == null) {
                list = new ArrayList<>();
                arr[c - 97] = list;
            } else if (list.size() >= 1) {
                maxLen = Math.max(i - list.get(0) - 1, maxLen);
            }

            list.add(i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        maxLengthBetweenEqualCharacters("aa");
    }

}
