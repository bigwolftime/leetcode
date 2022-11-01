package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最短补全词
 * https://leetcode.cn/problems/shortest-completing-word/
 *
 * @author liuxin
 * @date 2022/11/1 18:44
 */
public class ShortestCompletingWord {

    private static String shortestCompletingWord(String licensePlate, String[] words) {
        String res = null;
        Map<Character, Integer> map = buildCountMap(licensePlate);

        for (String word : words) {
            Map<Character, Integer> subMap = buildCountMap(word);

            boolean isMatch = isMatch(map, subMap);
            if (isMatch) {
                if (res == null) {
                    res = word;
                } else if (word.length() < res.length()) {
                    res = word;
                }
            }
        }

        return res;
    }

    private static Map<Character, Integer> buildCountMap(String licensePlate) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (isDigital(c) || c == ' ') {
                continue;
            }

            map.merge(toLowercase(c), 1, Integer::sum);
        }

        return map;
    }

    private static boolean isMatch(Map<Character, Integer> map, Map<Character, Integer> subMap) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer expectCnt = entry.getValue();

            Integer cnt = subMap.get(key);
            if (cnt == null || cnt < expectCnt) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    private static char toLowercase(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }

        return (char) (c + 32);
    }


    public static void main(String[] args) {
        String s = shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        System.err.println(s);
    }

}
