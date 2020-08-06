package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文对
 * https://leetcode-cn.com/problems/palindrome-pairs/
 *
 * todo 超时
 *
 * @author liuxin
 * @date 2020/8/6 21:42
 */
public class PalindromePairs {

    private static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    list.add(tempList);
                }
                if (isPalindrome(words[j] + words[i])) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(j);
                    tempList.add(i);
                    list.add(tempList);
                }
            }
        }

        return list;
    }

    private static boolean isPalindrome(String s) {
        int p = 0, q = s.length() - 1;
        while (p < q) {
            if (s.charAt(p) != s.charAt(q)) {
                return false;
            }

            p++;
            q--;
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll" });
        System.err.println(lists);
    }

}
