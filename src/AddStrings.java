/**
 * 字符串相加
 * https://leetcode-cn.com/problems/add-strings/description/
 * @author bwt
 *
 *	思路：
 *	两个指针 p 和 q 分别指向两个字符串的末尾，temp 计算结果，如果 temp >= 10 那么
 *借位标记 flag = true，直到两个指针的位置都指向 -1，最后判断进位为 true 那么插入 1.
 */
public class AddStrings {

	public static String addStrings(String num1, String num2) {
        int p = num1.length() - 1, q = num2.length() - 1;
        boolean flag = false;	//进位标记
        int temp = 0;
        StringBuilder res = new StringBuilder();
        
        while(p >= 0 || q >= 0) {
        	if (flag) {
        		temp += 1;
        		flag = false;
        	}
        	
        	if (p >= 0)
        		temp += num1.charAt(p) & 0x0f;
        	if (q >= 0)
        		temp += num2.charAt(q) & 0x0f;
        	
        	res.insert(0, temp % 10);
        	
        	if (temp >= 10)
        		flag = true;
        	
        	temp = 0;
        	p--;q--;
        }
        
        if (flag)
        	res.insert(0, 1);
		
		return res.toString();
    }
	
	public static void main(String[] args) {
		addStrings("823", "9444");
	}
}
