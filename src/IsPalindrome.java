/**
 * 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 * @author bwt
 *
 */
public class IsPalindrome {

	public static boolean isPalindrome(String s) {
        if ("".equals(s))
        	return true;
		
		int start = 0, end = s.length() - 1;
        int temp;
        while(start <= end) {
        	if (!isCharOrDigit(s.charAt(start)))
        		start++;
        	else if (!isCharOrDigit(s.charAt(end)))
        		end--;
        	else {
        		temp = Math.abs(s.charAt(start) - s.charAt(end));
        		
        		if (isAllChar(s.charAt(start), s.charAt(end))) {
                	if (!(temp == 32 || temp == 0))
                		return false;
        		}else {
        			if (temp != 0)
        				return false;
        		}
        		
            	start++;
            	end--;
        	}
        }
		
		return true;
    }
	
	public static boolean isCharOrDigit(char c) {
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	public static boolean isAllChar(char a, char b) {
		boolean flag1 = (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
		boolean flag2 = (b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z');
		return flag1 && flag2;
	}
	
	public static void main(String[] args) {
		boolean res = isPalindrome("P0");	//只考虑字母、数字
		System.err.println(res);
	}
}
