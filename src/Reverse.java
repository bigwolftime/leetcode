import java.util.ArrayList;
import java.util.List;

/**
 * 反转整数
 * https://leetcode-cn.com/problems/reverse-integer/description/
 * @author bwt
 *
 *	关键点在于判断是否出现溢出，这里使用 addExact()，出现溢出后抛出异常，捕获后 return 0，
 *办法有点投机取巧了。
 */
public class Reverse {

	public static int reverse(int x) {
		int res = 0, temp = x;
		List<Integer> list = new ArrayList<>();
		
		while(temp != 0) {
    		list.add(temp % 10);
    		temp /= 10;
    	}
		
		if (x > 0) {
			for(int i = list.size() - 1; i >= 0; i--) {
				try {
					//溢出会抛出异常，然后捕获
					Math.addExact(res, (int) (list.get(i) * Math.pow(10, list.size() - i - 1)));
				}catch (ArithmeticException e) {
					return 0;
				}
				res += list.get(i) * Math.pow(10, list.size() - i - 1);
			}
		}else {
			for(int i = list.size() - 1; i >= 0; i--) {
				try {
					Math.addExact(res, (int) (list.get(i) * Math.pow(10, list.size() - i - 1)));
				} catch (ArithmeticException e) {
					return 0;
				}
				res += list.get(i) * Math.pow(10, list.size() - i - 1);
			}
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		int res = reverse(123);
		System.err.println(res);
	}
}
