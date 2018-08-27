/**
 * 数字的补数
 * https://leetcode-cn.com/problems/number-complement/description/
 * @author bwt
 *
 *	条件：
 *	32 位有符号正整数；
 *	无前导 0；
 */
public class FindComplement {

	public static int findComplement(int num) {
		int index = 0;
		int res = 0;
		
        while(num != 0) {
        	if (num % 2 == 0)
        		res += Math.pow(2, index);
        	
        	num /= 2;
        	index++;
        }
        
		return res;
    }
	
	public static void main(String[] args) {
		int res = findComplement(8);
		System.err.println(res);
	}
}
