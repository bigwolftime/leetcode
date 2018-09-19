import java.util.ArrayList;
import java.util.HashSet;

/**
 * 找不同
 * https://leetcode-cn.com/problems/find-the-difference/description/
 * @author bwt
 *
 *	思路：
 *	起初的想法是用一个 list 存储 t 的每一个字符，然后分别与 s 的每一个字符比较后进行去除，
 *时间复杂度：O(M + N)，空间复杂度：O(N)
 *	更好的办法是使用位运算：时间复杂度：O(M)，空间复杂度：O(1)
 */
public class FindTheDifference {

	public static char findTheDifference(String s, String t) {
        /*ArrayList<Character> list = new ArrayList<>();
        
        for(int i = 0; i < t.length(); i++) {
        	list.add(t.charAt(i));
        }
        
        char c;
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
        	c = s.charAt(i);
        	
        	if (list.contains(c)) {
        		index = list.lastIndexOf(c);
        		
        		if (index != -1)
        			list.remove(index);
        	}else
        		return c;
        }
        
        return list.get(0);*/
		
		int i = 0;
        int find = 0;
        for (; i < s.length(); ++i) {
            find ^= (s.charAt(i) ^ t.charAt(i));
        }
        
        find ^= t.charAt(i);
        return (char) find;
    }
	
	public static void main(String[] args) {
		System.err.println(findTheDifference("a", "aa"));
	}
}
