package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计出现过一次的公共字符串
 * https://leetcode.cn/problems/count-common-words-with-one-occurrence/
 *
 * @author liuxin
 * @date 2022/10/19 20:15
 */
public class CountWords {

    private static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : words1) {
            map1.merge(s, 1, Integer::sum);
        }
        for (String s : words2) {
            map2.merge(s, 1, Integer::sum);
        }

        return map1.size() < map2.size() ? countWords(map1, map2) : countWords(map2, map1);
    }

    private static int countWords(Map<String, Integer> map1, Map<String, Integer> map2) {
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer integer = map2.get(key);

            if (entry.getValue() == 1 && integer != null && integer == 1) {
                cnt++;
            }
        }

        return cnt;
    }


    public static void main(String[] args) {
        countWords(new String[] { "hello" }, new String[]{});
    }

}
