/**
 * 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 * @author bwt
 *
 *	思路：
 *	使用位运算：参考《程序员代码面试指南》P321.
 *如果不考虑进位的话就是进行异或计算，但是
 */
public class GetSum {

	public static int getSum(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		
		int sum = 0;
		while(b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		
		return sum;
    }
	
	public static void main(String[] args) {
		getSum(-2, 3);
	}
}
