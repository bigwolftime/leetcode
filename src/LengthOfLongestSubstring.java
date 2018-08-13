import java.util.LinkedList;
import java.util.Queue;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * https://leetcode-cn.com/articles/longest-substring-without-repeating-characters/
 * @author bwt
 *
 *	思路：
 *	使用队列存储当前的最大无重复子串，如果队列包含 s.chatAt(i)，那么将此字符加入队列，将之前的字符全部删除后，更新 res；
 *	官方解答中，思路基本相同，不过使用 hashSet 存储，判断是否存在相同字符的时间复杂度是 O(1)，所以关键在于 queue.contains()
 *方法的时间复杂度，好像是 O(n).
 */
public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		Queue<Character> queue = new LinkedList<>();
		
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!queue.contains(s.charAt(i))) {
				queue.add(s.charAt(i));
			}else {
				queue.add(s.charAt(i));
				while(queue.peek() != s.charAt(i)) {
					queue.poll();
				}
				queue.poll();
			}
			res = Math.max(res, queue.size());
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		System.err.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
