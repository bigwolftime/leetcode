package leetcode;

/**
 * 子数组异或查询
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 *
 * 异或前缀数组
 */
public class XorQueries {

    private static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixArr = new int[arr.length + 1];
        prefixArr[1] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixArr[i + 1] = prefixArr[i] ^ arr[i];
        }

        int[] resArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] queryArr = queries[i];

            resArr[i] = prefixArr[queryArr[1] + 1] ^ prefixArr[queryArr[0]];
        }

        return resArr;
    }

    public static void main(String[] args) {

    }

}
