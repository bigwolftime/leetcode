package leetcode;

/**
 * 寻找数组的中心索引
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 * @author bwt
 *
 *	思路：
 *	起初我的想法是：创建两个指针 left 和 right 分别指向数组的两端，再创建两个变量 leftRes 和 rightRes 
 *分别表示左、右区域之和，哪边小则哪边指针向中间靠拢，循环条件：while(left < right)，但是这种办法只适用于
 *正数计算，如果包含负数，例如：-1,-1,-1,-1,-1,0，那么 leftRes 始终小于 rightRes，left 会不停地向中
 *间靠拢，结果不正确。但是感觉这种思路可行，只是具体还没有想到。
 *	更改后：
 *	循环一遍数组求和 sum；
 *	然后再次进入循环，每次求得 leftRes，那么不算当前位置 i，右半区的和为：sum - leftRes - nums[i]；
 *	如果循环结束都没有执行 return i，那么没有中心索引返回 -1.
 */
public class PivotIndex {

	public static int pivotIndex(int[] nums) {
		if (nums == null || nums.length <= 2)
			return -1;
		
		int leftRes = 0;
		int sum = 0;
		
		for (int i : nums) {
			sum += i;
		}	//计算所有值的总和
		
		for(int i = 0; i < nums.length; i++) {
			if (i != 0)
				leftRes += nums[i - 1];;
			
			if (leftRes == sum - nums[i] - leftRes)
				return i;
		}
		
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {-1,-1,0,1,1,0};
		System.err.println(pivotIndex(nums));
	}
}
