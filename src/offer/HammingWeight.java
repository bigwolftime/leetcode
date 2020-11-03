package offer;

/**
 * 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/submissions/
 *
 * @author liuxin
 * @time 2020/11/3 20:32
 */
public class HammingWeight {

    private static int hammingWeight(int n) {
        int count = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (char c : chars) {
            if (c == '1')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
