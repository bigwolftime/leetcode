package leetcode;

/**
 * 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * 1. 暴力匹配: 双层 for 循环, 在匹配的过程中还有一个 O(n). 结果是相乘的关系, 即: O(n ^ 3)
 * 2. 中心扩展: O(n ^ 2)
 */
public class CountSubstrings {

	private static int countSubstrings(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			count++;

			count += isPalindrome(s, i);
			count += isPalindromeGap(s, i);
		}

		return count;
	}

	private static int isPalindrome(String s, int index) {
		int count = 0;
		int p = index - 1, q = index + 1;
		if (p < 0 || q >= s.length()) {
			return count;
		}

		while (p >= 0 && q < s.length()) {
			if (s.charAt(p) != s.charAt(q)) {
				return count;
			} else {
				count++;
			}

			p--;
			q++;
		}

		return count;
	}

	private static int isPalindromeGap(String s, int index) {
		int count = 0;
		int p = index - 1, q = index;
		if (p < 0 || q >= s.length()) {
			return count;
		}

		while (p >= 0 && q < s.length()) {
			if (s.charAt(p) != s.charAt(q)) {
				return count;
			} else {
				count++;
			}

			p--;
			q++;
		}

		return count;
	}

	public static void main (String[] args) {
		int count = countSubstrings("a");
		System.err.println(count);
	}

}
