/**
 * 加一
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/772/
 * @author bwt
 *
 *	思路：
 *	首先分两种情况：最后一位数字 < 9，那么 +1 后直接返回；
 *	否则从数组末尾开始判断，是 9 的话就变为 0，直到不是 9 或者循环完毕；
 *	然后判断数组首位是否为 0，是则新加一位，如：{9,9}，计算完毕后为 {0,0}，此时要新加一位 1；
 *	不是的话就要找到 index 索引位置 +1，例：{3,7,9}，index 此时指向 7 的位置，即 index = 1，那么此位 +1
 *
 *	这个不是最好的方法，下面的注释中是最简洁的方法。
 */
public class PlusOne {
	
	public static int[] plusOne(int[] digits) {
		if (digits[digits.length - 1] < 9) {
			digits[digits.length - 1] = digits[digits.length - 1] + 1;
			return digits;
		}else {
			int index = digits.length - 1;
			while(index > 0 && digits[index--] == 9) {
				digits[index] = 0;
			}
			
			if (digits[0] == 0) {
				int[] res = new int[digits.length + 1];
				res[0] = 1;
				return res;
			}else {
				digits[index] = digits[index] + 1;
			}
			
			return digits;
		}
		
        /*int len = digits.length;
        for (int i = len - 1; i > -1; i--) {
            if (digits[i] == 9 ) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        
        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;*/
    }
	
	public static void main(String[] args) {
		int[] digits = new int[] {9,9};
		
		for (int i : plusOne(digits)) {
			System.err.println(i);
		}
	}
}
