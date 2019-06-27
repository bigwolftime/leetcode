/**
 * @Author Liuxin
 * @Date 2019/5/10 16:35
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zeroIndex = 0, index = 0;
        while (zeroIndex < nums.length && index < nums.length) {
            if (nums[zeroIndex] == 0) {
                while (index < nums.length) {
                    if (nums[index] != 0) {
                        nums[zeroIndex] = nums[index++];
                        break;
                    }
                }
            }
            zeroIndex++;
            index = index > zeroIndex ? index : zeroIndex;
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(null);
    }
}
