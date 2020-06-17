package leetcode;

/**
 * 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 * @author bwt
 *
 *	思路：
 *	暴力方式，不过不需要循环全部范围。
 */
public class JudgeSquareSum {

	public static boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        if (max * max == c)
        	return true;
        
        for (int i = 0; i <= max; i++) {
        	int j = (int) Math.sqrt(c - i * i);
        	
        	if (i * i + j * j == c)
        		return true;
        }
        
		return false;
    }
	
	public static void main(String[] args) {
		int[] params = new int[] {
			3, 5, 999999999
		};
		
		for (int i : params) {
			System.err.println(i + " : " + judgeSquareSum(i));
		}
		
	}
}
