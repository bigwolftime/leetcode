package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据字符出现频率排序
 * https://leetcode.cn/problems/sort-characters-by-frequency/
 *
 * hashMap 维护每个字符的次数, 然后堆排(或者二分 + 插入排序)
 *
 * @author liuxin
 * @date 2022/10/9 18:01
 */
public class FrequencySort {

    private static String frequencySort(String s) {
        // to countMap
        Map<Character, Integer> countMap = countMap(s);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            // binarySearch
            int i = binarySearch(list, entry.getValue());
            // insert
            list.add(i, entry);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            Map.Entry<Character, Integer> entry = list.get(i);
            for (int j = 0; j < entry.getValue(); j++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

    private static Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.merge(c, 1, Integer::sum);
        }

        return countMap;
    }

    private static int binarySearch(List<Map.Entry<Character, Integer>> list, int countVal) {
        int p = 0, q = list.size() - 1;
        int mid;

        while (p < q) {
            mid = p + ((q - p) >> 1);
            Map.Entry<Character, Integer> entry = list.get(mid);

            if (entry.getValue() > countVal) {
                q = mid - 1;
            } else if (entry.getValue() < countVal) {
                p = mid + 1;
            } else {
                return mid;
            }
        }

        if (q < 0) {
            return 0;
        }

        while (q < list.size() && list.get(q).getValue() <= countVal) {
            q++;
        }

        return q;
    }


    public static void main(String[] args) {
        String s = frequencySort("raaeaedere");
        System.err.println(s);
    }

}
