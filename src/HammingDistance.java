/**
 * 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/description/
 * @author bwt
 *
 *	思路：
 *	原来的思路是将计算出的二进制数据存入 list，然后逐一比较，但是没有必要占用额外空间，
 *所以在循环内分两种情况：
 *	x、y 都不是 0，那么直接比较二进制位，如果不同那么 res++；
 *	x、y 有一个是 0，那么当计算二进制位等于 1 时即不同，res++。
 */
public class HammingDistance {

	public static int hammingDistance(int x, int y) {
		int res = 0;
		
		while(x != 0 || y != 0) {
			if (x != 0 && y != 0) {
				if (x % 2 != y % 2)
					res++;
			}else {
				if (x != 0 && x % 2 == 1) {
					res++;
				}else if (y != 0 && y % 2 == 1) {
					res++;
				}
			}
			
			x /= 2;
			y /= 2;
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		System.err.println(hammingDistance(1, 4));
	}
}
