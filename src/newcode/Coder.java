package newcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author liuxin
 * @date 2024/9/20 10:17
 */
public class Coder {

    private static final String CODER = "coder";

    private static String[] findCoder(String[] A, int n) {
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(
                (o1, o2) -> o2 - o1
        );

        int totalCount = 0;
        for (String str : A) {
            int count = count(str.toLowerCase(), CODER);
            if (count == 0) {
                continue;
            }

            List<String> list = treeMap.computeIfAbsent(count, k -> new ArrayList<>());

            list.add(str);
            treeMap.put(count, list);

            totalCount++;
        }

        String[] result = new String[totalCount];
        int idx = 0;
        for (List<String> list : treeMap.values()) {
            for (String str : list) {
                result[idx++] = str;
            }
        }

        return result;
    }

    private static int count(String str, String targetStr) {
        int count = 0;
        int startIdx = 0;

        while (startIdx < str.length()) {
            int idx = find(str, startIdx, targetStr);
            if (idx == -1) {
                return count;
            }

            count++;
            startIdx = idx + targetStr.length();
        }

        return count;
    }

    private static int find(String str, int startIdx, String targetStr) {
        if (startIdx >= str.length()) {
            return -1;
        }

        return str.indexOf(targetStr, startIdx);
    }

    public static void main(String[] args) {
        String[] A = new String[]{"i am a coder","Coder Coder","Code"};
        findCoder(A, 3);
    }

}
