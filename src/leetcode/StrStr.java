package leetcode;

/**
 * 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/description/
 * @author bwt
 *
 *	思路：
 *	对字符串的匹配算法还不是特别熟悉，摸索出来的，思路不是特别难。
 */
public class StrStr {

	public static int strStr(String haystack, String needle) {
		if ("".equals(haystack) && "".equals(needle))
			return 0;
		if ("".equals(needle))
			return 0;
		
		int p = 0, q = 0;
		int index = -1;
		
		while(p < haystack.length()) {
			if (haystack.charAt(p) == needle.charAt(q)) {
				p++;
				q++;
				
				if (q >= needle.length()) {
					index = p - needle.length();
					break;
				}
			}else {
				if (q != 0) {
					p = p - q + 1;
					q = 0;
					continue;
				}
				p++;
			}
		}
		
        return index;
    }
	
	public static void main(String[] args) {
		int res = strStr("aaaaa", "aaa");
		System.err.println(res);
	}
}
