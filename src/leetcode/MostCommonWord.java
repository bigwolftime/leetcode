package leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 最常见的单词
 * https://leetcode-cn.com/problems/most-common-word/
 */
public class MostCommonWord {

    private static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banSet = new HashSet<>(Arrays.asList(banned));

        int maxCnt = 0;
        String resStr = "";

        HashMap<String, Integer> map = new HashMap<>();
        int startIdx = 0;
        while (startIdx < paragraph.length()) {
            Pair<String, Integer> pair = nextStr(paragraph, startIdx);
            String str = pair.getKey();
            startIdx = pair.getValue();

            if (banSet.contains(str) || str.length() == 0) {
                continue;
            }

            Integer cnt = map.get(str);
            if (cnt == null) {
                cnt = 1;
            } else {
                cnt++;
            }

            map.put(str, cnt);

            if (cnt > maxCnt) {
                resStr = str;
                maxCnt = cnt;
            }

        }

        return resStr;
    }

    private static Pair<String, Integer> nextStr(String paragraph, int startIdx) {
        while (startIdx < paragraph.length() && !isChar(paragraph.charAt(startIdx))) {
            startIdx++;
        }

        StringBuilder sb = new StringBuilder();
        for (; startIdx < paragraph.length(); startIdx++) {
            char c = paragraph.charAt(startIdx);

            if (!isChar(c)) {
                return new Pair<>(sb.toString(), startIdx);
            }

            if (c < 97) {
                c += 32;
            }

            sb.append(c);
        }

        return new Pair<>(sb.toString(), startIdx);
    }

    private static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{ "hit" });
    }

}
