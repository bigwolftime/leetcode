package leetcode;

/**
 * 存在连续三个奇数的数组
 * https://leetcode-cn.com/problems/three-consecutive-odds/
 */
public class ThreeConsecutiveOdds {

	private static boolean threeConsecutiveOdds(int[] arr) {
		int count = 0;

		for (int i : arr) {
			if ((i & 1) == 0) {
				count = 0;
			} else {
				count++;
			}

			if (count >= 3) {
				return true;
			}
		}

		return false;
	}

	public static void main (String[] args) {

	}

}
