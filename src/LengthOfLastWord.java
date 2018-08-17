/**
 * 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 * @author bwt
 *
 *	思路：
 *	输入情况分类：
 *	1、空字符串，返回 0；
 *	2、"hello world"，正常的输入，那么从后向前遍历，遇到空格或遍历结束后返回移动下标的距离；
 *	3、"Hello "，末尾带有 1 个或者 n 个空格，使用递归的方法，字符串范围从 0 到 s.length - 1
 *(去掉字符串最后位置的空格)。
 */
public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
		if ("".equals(s))
			return 0;
		
		if (s.charAt(s.length() - 1) == ' ') {
			return lengthOfLastWord(s.substring(0, s.length() - 1));
		}else {
			int index = s.length() - 1;
			while(index >= 0) {
				if (s.charAt(index) == ' ')
					break;
				index--;
			}
			
	        return s.length() - index - 1;
		}
    }
	
	public static void main(String[] args) {
		String str = "a ";
		int res = lengthOfLastWord(str);	//仅包含大小写字母及空格
		System.err.println(res);
	}
}
