
/**
 * @Author Liuxin
 * @Date 2019/4/1 17:26
 */
public class MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        int len = 0, sum = 0;
        int curLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            curLen++;

            if (sum >= s) {
                len = Math.max(len, curLen);
                curLen = 0;
                sum = 0;
                continue;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.err.println(minSubArrayLen(11, nums));
    }
}
