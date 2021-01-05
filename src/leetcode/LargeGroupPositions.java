package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 较大分组的位置
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 */
public class LargeGroupPositions {

    private static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> resList = new ArrayList<>();

        int startIdx = 0;
        while (startIdx < s.length()) {
            int endIdx = startIdx;
            char c = s.charAt(startIdx);

            for (int i = startIdx + 1; i < s.length(); i++) {
                if (s.charAt(i) != c) {
                    break;
                }

                endIdx = i;
            }

            if (endIdx - startIdx >= 2) {
                List<Integer> list = new ArrayList<>();
                list.add(startIdx);
                list.add(endIdx);
                resList.add(list);
            }

            startIdx = endIdx + 1;
        }

        return resList;
    }

    public static void main(String[] args) {

    }

}
