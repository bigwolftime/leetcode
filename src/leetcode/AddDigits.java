package leetcode;

/**
 * 各位相加
 * https://leetcode-cn.com/problems/add-digits/description/
 * @author bwt
 *
 *	这道题的进阶部分要求不使用递归或者循环，且 O(1) 时间复杂度，不过目前想不到
 *更好的办法。
 */
public class AddDigits {

	public static int addDigits(int num) {
		int res = 0;
        while(true) {
        	res = res + num % 10;
        	num /= 10;
        	
        	if (num == 0 && res < 10)
        		break;
        	else if (num == 0 && res >= 10) {
        		num = res;
        		res = 0;
        	}
        }
		
		return res;
    }
	
	public static void main(String[] args) {
		System.err.println(addDigits(29));
	}
}
