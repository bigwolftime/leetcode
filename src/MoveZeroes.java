/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * 思路：使用双指针法，比较简单
 * @Author Liuxin
 * @Date 2019/5/10 16:35
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int zeroIndex = 0, cur = 0;
        while (cur < nums.length) {
            //cur 定位到非 0 元素
            while (cur < nums.length && nums[cur] == 0){
                cur++;
            }

            if (cur < nums.length){
                nums[zeroIndex] = nums[cur];
                cur++;
                zeroIndex++;
            }
        }

        while (zeroIndex < nums.length){
            nums[zeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        moveZeroes(nums);

        for (int i : nums){
            System.err.print(i + ".");
        }
    }
}
