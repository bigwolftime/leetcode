/**
 * 猜数字大小
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/description/
 * @author bwt
 *
 *	二分查找的注意事项：求中间值 mid 可能会溢出，即当 p + q 的值大于该类型的最大值时会出现溢出。
 */
public class GuessNumber {

	public static int guessNumber(int n) {
        int p = 1, q = n;
        int mid;
        
        while( p <= q) {
        	mid = p + ((q - p) >> 1);
        	
        	if (guess(mid) == 1) {
        		p = mid + 1;
        	}else if (guess(mid) == -1) {
        		q = mid - 1;
        	}else
        		return mid;
        }
		
        return 0;
    }
	
	public static int guess(int guess) {
		return guess == 1702766719 ? 0 : (guess > 1702766719 ? -1 : 1);
	}
	
	public static void main(String[] args) {
		System.err.println(guessNumber(2126753390));
	}
}
