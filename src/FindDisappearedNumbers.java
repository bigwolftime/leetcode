import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * @author bwt
 *
 *	思路：
 *	题目中要求最好不适用额外空间并且时间复杂度 O(n)，没有想到办法；
 *	目前的解法：声明一个 nums.length 长度的数组，当数字出现的时候，把对应的下标 - 1
 *位置置为 1，最后下标等于 0 处即消失的数字。
 */
public class FindDisappearedNumbers {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
		int[] temp = new int[nums.length];
        
        for (int i : nums) {
			temp[i - 1] = 1;
		}
		
        for (int i = 0; i < temp.length; i++) {
        	if (temp[i] == 0)
        		res.add(i + 1);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {4,3,2,7,8,2,3,1};
		System.err.println(findDisappearedNumbers(nums));
	}
}
