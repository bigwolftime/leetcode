package leetcode;

/**
 * 替换所有的问号
 * https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */
public class ModifyString {

	private static String modifyString(String s) {
		StringBuilder sb = new StringBuilder(s);

		char left, right;
		for (int i = 0; i < sb.length(); i++) {
			left = '0';
			right = '0';

			if (sb.charAt(i) == '?') {
				if (i > 0) {
					left = sb.charAt(i - 1);
				}
				if (i < sb.length() - 1) {
					right = sb.charAt(i + 1);
				}

				for (char c = 'a'; c <= 'z'; c++) {
					if (c != left && c != right) {
						sb.replace(i, i + 1, String.valueOf(c));
						break;
					}
				}
			}
		}

		return sb.toString();
	}

	public static void main (String[] args) {

	}

}
