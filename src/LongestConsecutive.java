import java.util.HashSet;

/**
 * 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author liuxin
 * @date 2020/6/6 11:24
 */
public class LongestConsecutive {

    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int maxLen = 0, len;
        int temp;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                len = 1;
                temp = i;

                while (set.contains(++temp)) {
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{100,4,200,1,3,2});
    }

}
