package leetcode;

/**
 * 数组中的最长山脉
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 *
 * 双指针
 * 时间复杂度: O(n)
 *
 * @author liuxin
 * @date 2020/10/25 0:06
 */
public class LongestMountain {

    private static int longestMountain(int[] A) {
        int p = 0, q = p + 1;
        int start = 0, end = 0;
        int maxLen = 0;

        boolean leftFlag, rightFlag;
        while (q < A.length) {
            leftFlag = false;

            while (q < A.length && A[q] > A[p]) {
                if (!leftFlag) {
                    start = p;
                    leftFlag = true;
                }
                p++;
                q++;
            }

            if (leftFlag) {
                rightFlag = false;

                while (q < A.length && A[q] < A[p]) {
                    rightFlag = true;
                    end = q;
                    p++;
                    q++;
                }

                if (rightFlag) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            } else {
                p++;
                q++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        longestMountain(new int[]{ 1,2,3 });
    }

}
