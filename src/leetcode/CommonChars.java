package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * 使用计数法 准备 n 个容量 26 的数组
 *
 * @author liuxin
 * @time 2020/10/14 16:51
 */
public class CommonChars {

    private static List<String> commonChars(String[] A) {
        if (A.length == 0) {
            return new ArrayList<>();
        }

        int[][] arr = new int[A.length][26];
        String s;
        char c;

        for (int i = 0; i < A.length; i++) {
            s = A[i];

            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);

                arr[i][c - 97]++;
            }
        }

        List<String> list = new ArrayList<>();
        int maxCount;

        for (int i = 0; i < arr[0].length; i++) {
            maxCount = Integer.MAX_VALUE;
            for (int[] ints : arr) {
                maxCount = Math.min(maxCount, ints[i]);
            }

            while (maxCount-- > 0) {
                c = (char) (i + 97);
                list.add(String.valueOf(c));
            }
        }

        return list;
    }

    public static void main(String[] args) {

    }

}
