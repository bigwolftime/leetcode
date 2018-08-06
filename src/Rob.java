/**
 * 打家劫舍
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/57/
 * @author bwt
 *
 *	思路：
 *	参考：https://www.codercto.com/a/6239.html
 *	若数组长度为 1，返回数组 "第一项的值"；
 *	若数组长度为 2，返回 "第一项的值" 和 "第二项的值" 较大的一个；
 *	若数组长度为 3，返回 "数组长度为 1 的情况 + 第三项的值" 和 "数组长度为 2 的情况" 较大的一个；
 *	若数组长度为 4，返回 "数组长度为 2 的情况 + 第四项的值" 和 "数组长度为 3 的情况" 较大的一个；
 *	题目要求不能打劫相邻两家，所以 当前项 与 上上次 的结果相加。
 *	F(1) = nums[0]
 *	F(2) = Math.max(nums[0], nums[1])
 *	F(3) = Math.max(F(1) + nums[2], F(2))
 *	F(4) = Math.max(F(2) + nums[3], F(3))
 *	...
 *	F(N) = Math.max(F(N - 2) + nums[N - 1], F(N - 1))
 */
public class Rob {

    public static int rob(int[] nums) {
    	if (nums == null)
    		return 0;
    	
    	int a = 0, b = 0, res = 0;
    	for (int i : nums) {
    		a = b;
    		b = res;
    		res = Math.max(a + i, res);
		}
    	
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,7,9,3,1};
		System.err.println(rob(nums));
	}
}
