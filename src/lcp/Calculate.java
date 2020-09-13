package lcp;

/**
 * 速算机器人
 * https://leetcode-cn.com/problems/nGK0Fy/
 */
public class Calculate {

	private static int calculate(String s) {
		int x = 1, y = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				x = 2 * x + y;
			} else {
				y = 2 * y + x;
			}
		}

		return x + y;
	}

	public static void main (String[] args) {

	}

}
