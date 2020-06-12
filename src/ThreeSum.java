import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 三数之和(相加为 0)
 *
 * @author liuxin
 * @time 2020/6/12 14:54
 */
public class ThreeSum {

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int leftIdx = 0, rightIdx = nums.length - 1;
        int pIdx;
        int left, right;
        int sum;

        while (rightIdx - leftIdx > 1) {
            left = nums[leftIdx];
            right = nums[rightIdx];
            sum = left + right;

            pIdx = leftIdx + 1;
            while (pIdx < rightIdx) {
                if (nums[pIdx] + sum == 0) {
                    // new list
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[leftIdx]);
                    tempList.add(nums[pIdx]);
                    tempList.add(nums[rightIdx]);
                    list.add(tempList);
                    break;
                }

                pIdx++;
            }

            if (nums[leftIdx] + nums[rightIdx] <= 0) {
                leftIdx++;
                while (nums[leftIdx] == nums[leftIdx - 1] && leftIdx < rightIdx) {
                    leftIdx++;
                }
            } else {
                rightIdx--;
                while (nums[rightIdx] == nums[rightIdx + 1] && rightIdx > leftIdx) {
                    rightIdx--;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.err.println(threeSum(new int[]{ -2,0,1,1,2 }));;
    }

}
