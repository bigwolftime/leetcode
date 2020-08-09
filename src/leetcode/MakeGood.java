package leetcode;

/**
 * 整理字符串
 * https://leetcode-cn.com/problems/make-the-string-great/
 */
public class MakeGood {

	private static String makeGood(String s) {
		StringBuilder sb = new StringBuilder(s);
		int idx = 0;

		char c1, c2;
		while (true) {
			if (idx < 0) {
				idx = 0;
			}
			if (idx >= sb.length() - 1) {
				// 结束条件
				 break;
			}

			c1 = sb.charAt(idx);
			c2 = sb.charAt(idx + 1);
			if (c1 - 32 == c2 || c1 + 32 == c2) {
				sb.replace(idx, idx + 2, "");
				idx--;
			} else {
				idx++;
			}
		}

		return sb.toString();
	}



	public static void main (String[] args) {
		System.err.println(makeGood(""));
	}

}
