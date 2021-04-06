package leetcode;

/**
 * 删除有序数组中的重复项II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * 双指针
 * 使用一个 LIMIT 记录当前的最大长度，随着算法进行，LIMIT 可能会变小
 */
public class RemoveDuplicatesWithMaxCount {

    /**
     * 数据最大遍历长度，随着算法进行，LIMIT 可能会不断变小
     */
    private static int LIMIT;

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        LIMIT = nums.length;

        // 当前元素值
        int curNum = nums[0];
        // 当前元素已出现次数
        int curCount = 1;

        for (int i = 1; i < LIMIT; i++) {
            int x = nums[i];

            if (x != curNum) {
                curCount = 1;
                curNum = x;
            } else {
                curCount++;

                if (curCount > 2) {
                    resize(nums, i, x);

                    // resize 后重置 curNum curCount
                    curNum = nums[i];
                    curCount = 1;
                }
            }
        }

        return LIMIT;
    }

    /**
     * resize
     * @param arr
     * @param resizeIndex
     * @param curNum
     */
    private static void resize(int[] arr, int resizeIndex, int curNum) {
        int curRemoveCount = 1;

        for (int i = resizeIndex + 1; i < LIMIT; i++) {
            if (arr[i] != curNum) {
                break;
            }

            curRemoveCount++;
        }

        LIMIT -= curRemoveCount;

        for (int i = resizeIndex; i < LIMIT; i++) {
            arr[i] = arr[i + curRemoveCount];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,1,1,2,2,3,3,3,3 };

        int i = removeDuplicates(arr);

        for (int x : arr) {
            System.err.println(x);
        }

        System.err.println("----");
        System.err.println(i);
    }

}
