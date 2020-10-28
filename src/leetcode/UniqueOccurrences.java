package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 独一无二的出现次数
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 *
 * @author liuxin
 * @date 2020/10/28 8:12
 */
public class UniqueOccurrences {

    private static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : arr) {
            map.merge(val, 1, Integer::sum);
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer count : map.values()) {
            if (!set.add(count)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
