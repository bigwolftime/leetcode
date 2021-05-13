package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String rebuild = rebuild(str);

            List<String> list = map.get(rebuild);
            if (list == null) {
                list = new ArrayList<>();
                list.add(str);
                map.put(rebuild, list);
            } else {
                list.add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String rebuild(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = searchChar(sb, c);

            sb.insert(idx, c);
        }

        return sb.toString();
    }

    private static int searchChar(StringBuilder sb, char c) {
        if (sb.length() == 0) {
            return 0;
        }
        int p = 0, q = sb.length() - 1;

        while (p < q) {
            int mid = p + ((q - p) >> 1);

            if (c < sb.charAt(mid)) {
                q = mid;
            } else if (c > sb.charAt(mid)) {
                p = mid + 1;
            } else {
                return mid;
            }
        }

        return c > sb.charAt(p) ? p + 1 : p;
    }

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.err.println(lists);
    }

}
