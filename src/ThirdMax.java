/**
 * 第三大的数
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 * @author bwt
 *
 */
public class ThirdMax {

	public static int thirdMax(int[] nums) {
		long first = Long.MIN_VALUE, sec = Long.MIN_VALUE, third = Long.MIN_VALUE;
		
        for (int i : nums) {
			if (i > first) {
				third = sec;
				sec = first;
				first = i;
			}else if (i > sec && i < first) {
				third = sec;
				sec = i;
			}else if (i > third && i < sec) {
				third = i;
			}
		}
		
		return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {
				1,2,2,5,3,5
		};
		System.err.println(thirdMax(nums));
	}
}
