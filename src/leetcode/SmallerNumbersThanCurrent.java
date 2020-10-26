package leetcode;

/**
 * 有多少小于当前数字的数字
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * 可用 map 计数.
 * 题中给定: 0 <= nums[i] <= 100, 所以可以用 101 空间的数组
 *
 * @author liuxin
 * @time 2020/10/26 14:50
 */
public class SmallerNumbersThanCurrent {

    private static int[] smallerNumbersThanCurrent(int[] nums) {
        // 计数
        if (nums.length == 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return new int[]{ 0 };
        }


        int[] countArr = new int[101];
        for (int val : nums) {
            countArr[val]++;
        }

        int[] prefixArr = new int[101];
        prefixArr[0] = 0;
        for (int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] = countArr[i - 1] + prefixArr[i - 1];
        }

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = prefixArr[nums[i]];
        }

        return arr;

        // map
        /*int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            map.put(arr[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            arr[i] = map.get(nums[i]);
        }

        return arr;*/
    }

    public static void main(String[] args) {

    }

}
