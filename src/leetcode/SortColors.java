package leetcode;

/**
 * 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author liuxin
 * @time 2020/6/9 20:16
 */
public class SortColors {

    private static void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int i : nums) {
            arr[i]++;
        }

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < arr[i]; x++) {
                nums[idx++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{ 2,0,2,1,1,0 };
        sortColors(x);

        for (int i : x) {
            System.err.println(i);
        }
    }

}
