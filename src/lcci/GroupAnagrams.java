package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 变位词组
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 使用 hash 分组
 */
public class GroupAnagrams {

    private static final String UNDER_LINE = "_";

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 排序 & 构造 key
            String key = buildKey(str);

            List<String> list = map.get(key);

            if (list == null) {
                list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                list.add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String buildKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c).append(UNDER_LINE);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{ "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> list = groupAnagrams(strs);

        System.err.println(list);
    }

}
