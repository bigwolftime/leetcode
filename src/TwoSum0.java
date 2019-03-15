import java.util.HashMap;
import java.util.Objects;

/**
 * @Author Liuxin
 * @Date 2019/3/15 14:21
 *
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum0 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        Integer key;
        for (int i = 0; i < nums.length; i++){
            key = target - nums[i];
            if (Objects.nonNull(map.get(key)) && i != map.get(key)){
                return new int[] {i, map.get(key)};
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};

        int[] res = twoSum(nums, 6);
        for (int i : res){
            System.err.println(i);
        }
    }
}
