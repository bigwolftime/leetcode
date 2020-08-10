package leetcode;

/**
 * 计数二进制子串
 * https://leetcode-cn.com/problems/count-binary-substrings/
 *
 * 寻找 0,1 的交界，然后扩张
 */
public class CountBinarySubstrings {

	private static int countBinarySubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int count = 0;
		int last, next;
		int lastIdx, nextIdx;

		for (int i = 1; i < s.length(); i++) {
			lastIdx = i - 1;
			nextIdx = i;
			last = s.charAt(lastIdx);
			next = s.charAt(nextIdx);

			if (last != next) {
				count++;

				// 寻找 0,1 的交界
				while (--lastIdx >= 0 && ++nextIdx < s.length()) {
					if (last == s.charAt(lastIdx) && next == s.charAt(nextIdx)) {
						count++;
					} else {
						break;
					}
				}
			}
		}

		return count;
	}

	public static void main (String[] args) {
		System.err.println(countBinarySubstrings("10101"));
	}

}
