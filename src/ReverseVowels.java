/**
 * 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 * @author bwt
 *
 *	思路：
 *	涉及到字符串的替换，String 是不可变对象，所以将 s 转换为数组，然后两个指针分别从两端向中间移动。
 */
public class ReverseVowels {

	public static String reverseVowels(String s) {
		char[] strs = s.toCharArray();
		
        int p = 0, q = strs.length - 1;
        char c;
        while(p < q) {
        	while(p <= q) {
        		if (isVowel(strs[p]))
        			break;
        		p++;
        	}
        	while(q >= p) {
        		if (isVowel(strs[q]))
        			break;
        		q--;
        	}
        	
        	if (p < q) {
        		c = strs[p];
            	strs[p] = strs[q];
            	strs[q] = c;	//交换
            	p++;q--;	//交换完毕后两个指针向中间靠拢
        	}
        }
		
        StringBuilder res = new StringBuilder();
        for (char string : strs) {
			res.append(string);
		}
        
		return res.toString();
    }
	
	public static boolean isVowel(char c) {
		boolean flag1 = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
		boolean flag2 = c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
		return flag1 || flag2;
	}
	
	public static void main(String[] args) {
		System.err.println(reverseVowels("hello"));
	}
}
