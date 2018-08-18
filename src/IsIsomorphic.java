import java.util.HashMap;

/**
 * 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 * @author bwt
 *
 *	思路：
 *	如果只用 map 来记录 s 对 t 的映射，而不使用 helpMap 的话有漏洞，例：ab aa，map 的映射：
 *a:a, b:a，返回结果为 true；如果是 aa，ab 的话返回 false。这就是注意的地方，所以再用一个辅
 *助空间 helpMap，记录 t 对 s 的映射，根据两个字符不能映射到同一个字符，即不能出现：a:c, b:c
 *情况，所以当 helpMap 不是空并且 此映射不等于 s 的目标映射，返回 false。
 */
public class IsIsomorphic {

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		
		HashMap<Character, Character> map = new HashMap<>();
		HashMap<Character, Character> helpMap = new HashMap<>();
		
		int p = 0, q = 0;
		
		while(p < s.length()) {
			if (map.containsKey(s.charAt(p))) {
				if (map.get(s.charAt(p)) != t.charAt(q))
					return false;
			}else {
				map.put(s.charAt(p), t.charAt(q));
				
				if (helpMap.containsKey(t.charAt(q))) {
					if (helpMap.get(t.charAt(q)) != s.charAt(p))
						return false;
				}else
					helpMap.put(t.charAt(q), s.charAt(p));
			}
			
			p++;
			q++;
		}
        
		return true;
    }
	
	public static void main(String[] args) {
		System.err.println(isIsomorphic("aa", "ab"));
	}
}
