import java.util.HashMap;

/**
 * 单词模式
 * https://leetcode-cn.com/problems/word-pattern/description/
 * @author bwt
 *
 *	思路有点类似于 "同构字符串-https://leetcode-cn.com/problems/isomor
 *phic-strings/description/
 *	时间复杂度 O(N)，空间复杂度 O(N)
 */
public class WordPattern {

	public static boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (pattern.length() != strs.length)
			return false;
		
		HashMap<Character, String> map = new HashMap<>();
		HashMap<String, Character> helpMap = new HashMap<>();
		
		int p = 0, q = 0;
		while(p < pattern.length()) {
			if (map.containsKey(pattern.charAt(p))) {
				if (!map.get(pattern.charAt(p)).equals(strs[q]))
					return false;
			}else
				map.put(pattern.charAt(p), strs[q]);
			
			if (helpMap.containsKey(strs[q])) {
				if (!helpMap.get(strs[q]).equals(pattern.charAt(p)))
					return false;
			}else
				helpMap.put(strs[q], pattern.charAt(p));
			
			p++;
			q++;
		}
        
		return true;
    }
	
	public static void main(String[] args) {
		System.err.println(wordPattern("abba", "dog dog dog dog"));
	}
}
