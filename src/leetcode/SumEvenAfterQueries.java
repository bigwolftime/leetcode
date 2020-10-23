package leetcode;

/**
 * 查询后的偶数和
 * https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/
 *
 * @author liuxin
 * @time 2020/10/23 14:24
 */
public class SumEvenAfterQueries {

    private static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for (int val : A) {
            if ((val & 1) == 0) {
                evenSum += val;
            }
        }

        int cur;
        int[] arr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            cur = A[queries[i][1]];

            if ((cur & 1) == 0) {
                // even

                cur += queries[i][0];
                if ((cur & 1) == 0) {
                    evenSum += queries[i][0];
                } else {
                    evenSum -= A[queries[i][1]];
                }

            } else {
                // odd

                cur += queries[i][0];

                if ((cur & 1) == 0) {
                    evenSum += cur;
                }
            }

            A[queries[i][1]] = cur;
            arr[i] = evenSum;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] A = new int[]{ 1,2,3,4 };
        int[][] queries = new int[][]{
                { 1,0 },
                { -3,1 },
                { -4,0 },
                { 2,3 }
        };

        sumEvenAfterQueries(A, queries);
    }

}
