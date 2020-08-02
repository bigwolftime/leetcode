package leetcode;

/**
 * 统计好三元组
 * https://leetcode-cn.com/problems/count-good-triplets/
 *
 * @author liuxin
 * @date 2020/8/2 10:46
 */
public class CountGoodTriplets {

    private static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }

        System.err.println(count);
        return count;
    }

    public static void main(String[] args) {
        countGoodTriplets(new int[]{ 3,0,1,1,9,7 }, 7,2,3);
    }

}
