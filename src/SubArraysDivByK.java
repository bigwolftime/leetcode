/**
 * 和可被 K 整除的数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 *
 * @author liuxin
 * @time 2020/5/27 11:12
 */
public class SubArraysDivByK {

    private static int subArraysDivByK(int[] A, int K) {




        return -1;


        // 暴力解法会超时
        /*int original;
        for (int i = 0; i < A.length; i++) {
            original = A[i];
            for (int j = i + 1; j <= A.length; j++) {
                if (original % 5 == 0) {
                    System.err.println(i + ":" + (j - 1));
                }

                original += (j < A.length ? A[j] : 0);
            }
        }*/
    }

    public static void main(String[] args) {
        subArraysDivByK(new int[]{ 4,5,0,-2,-3,1 }, 5);
        System.err.println(-9 % 5);
    }

}
