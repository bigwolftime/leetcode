package leetcode;

/**
 * 字符串转整数(atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/description/
 * @author bwt
 *
 *	可以使用两个变量 startIndex 和 endIndex 来标记有效数字，然后循环计算同时出现溢出的话
 *就返回 Integer.MAX_VALUE 或者 Integer.MIN_VALUE.
 */
public class MyAtoi {

	public static int myAtoi(String str) {
		boolean isPositiveNum = false;	//是否正数
		char c;
		
		int startIndex = 0, endIndex = 0;
		while(startIndex < str.length()) {
			if (str.charAt(startIndex) != ' ')
				break;
			startIndex++;
		}	//首先确定第一个数字的索引
		
		if (startIndex < str.length() && startMatch(str.charAt(startIndex))) {
			c = str.charAt(startIndex);
			if (c == '-') {
				isPositiveNum = false;
				startIndex++;
			}else if (c == '+') {
				isPositiveNum = true;
				startIndex++;
			}else
				isPositiveNum = true;
			endIndex = startIndex;
			
			while(endIndex < str.length()) {
				if (!isDigital(str.charAt(endIndex)))
					break;
				
				endIndex++;
			}
			
			int res = 0;
			if (isPositiveNum) {
				for (int i = endIndex - 1; i >= startIndex; i--) {
					try {
						res = Math.addExact(res, (int) ((str.charAt(i) & 0x0f) * Math.pow(10, endIndex - 1 - i)));
					}catch (ArithmeticException e) {
						return Integer.MAX_VALUE;
					}
				}
			}else {
				for (int i = endIndex - 1; i >= startIndex; i--) {
					try {
						res = Math.subtractExact(res, (int) ((str.charAt(i) & 0x0f) * Math.pow(10, endIndex -1 - i)));
					}catch (ArithmeticException e) {
						return Integer.MIN_VALUE;
					}
				}
			}
			
			return res;
		}else
			return 0;
    }
	
	//去掉空格后的单词开头是否符合要求
	public static boolean startMatch(char c) {
		return isDigital(c) || c == '-' || c == '+';
	}
	
	public static boolean isDigital(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static void main(String[] args) {
		System.out.println(myAtoi("  +4.2"));
	}
}
