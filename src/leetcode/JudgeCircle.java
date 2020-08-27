package leetcode;

/**
 * 机器人能否返回原点
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class JudgeCircle {

	private static boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		char c;

		for (int i = 0; i < moves.length(); i++) {
			c = moves.charAt(i);

			switch (c) {
				case 'L':
					y -= 1;
					break;
				case 'R':
					y += 1;
					break;
				case 'U':
					x -= 1;
					break;
				case 'D':
					x += 1;
					break;
			}
		}

		return x == 0 && y == 0;
	}

	public static void main (String[] args) {

	}

}
