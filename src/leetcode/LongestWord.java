package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 词典中最长的单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 *
 * @author liuxin
 * @date 2020/8/31 14:55
 */
public class LongestWord {

    private static String longestWord(String[] words) {
        Arrays.sort(words);

        HashSet<String> prefixSet = new HashSet<>();
        String maxLenWord = "";

        for (String str : words) {
            // 长度1  || 包含前缀 -> 添加本次 str
            if (str.length() == 1 || prefixSet.contains(str.substring(0, str.length() - 1))) {
                prefixSet.add(str);

                // 判断长度
                if (str.length() > maxLenWord.length()) {
                    maxLenWord = str;
                }
            }
        }

        return maxLenWord;
    }

    public static void main(String[] args) {
        System.err.println(longestWord(new String[]{ "ewqz","yodn" }));
    }

}
