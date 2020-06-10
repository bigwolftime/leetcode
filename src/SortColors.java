/**
 * @author liuxin
 * @time 2020/6/9 20:16
 */
public class SortColors {

    private static void sortColors(int[] nums) {
        int[] arr = new int[2];

        for (int i : nums) {
            arr[i]++;
        }

        int count = nums.length;
        while (count-- > 0) {

        }

    }

    public static void main(String[] args) {
        sortColors(new int[]{ 2,0,2,1,1,0 });
    }

}
