package leetcode;

/**
 * 行星碰撞
 * https://leetcode-cn.com/problems/asteroid-collision/
 *
 * 双指针, 需要注意下细节(溢出等)
 */
public class AsteroidCollision {

	private static int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length <= 1) {
			// 数据为空 || 数据量<=1 -> 原状返回
			return asteroids;
		}

		int l = 0, r = l + 1;
		int lVal, rVal;
		int boom = 0;

		while (r < asteroids.length && l < r) {
			lVal = asteroids[l];
			rVal = asteroids[r];

			if (lVal == 0) {
				l--;
			} else {
				if (willCollision(lVal, rVal)) {
					// 会发生碰撞
					int compare = Integer.compare(Math.abs(lVal), Math.abs(rVal));

					if (compare == 0) {
						asteroids[l] = 0;
						asteroids[r] = 0;

						l--;
						r++;
						boom += 2;
					} else if (compare > 0) {
						// 左大, 右爆炸
						asteroids[r] = 0;
						r++;
						boom++;
					} else {
						// 右大, 左爆炸
						asteroids[l] = 0;
						l--;
						boom++;
					}

				} else {
					// 不会碰撞
					r++;
					l = r - 1;
				}
			}

			if (l < 0) {
				// 左越界
				l = r;
				r = l + 1;
			}
		}

		int[] resArr = new int[asteroids.length - boom];
		int index = 0;
		for (int i : asteroids) {
			if (i != 0) {
				resArr[index++] = i;
			}
		}

		return resArr;
	}

	/**
	 * 是否碰撞
	 * @param lVal
	 * @param rVal
	 * @return
	 */
	private static boolean willCollision(int lVal, int rVal) {
		if (lVal < 0 && rVal > 0) {
			return false;
		}
		if ((lVal < 0 && rVal < 0) || (lVal > 0 && rVal > 0)) {
			return false;
		}
		if (lVal == 0 || rVal == 0) {
			return false;
		}

		return true;
	}

	public static void main (String[] args) {
		asteroidCollision(new int[]{ 1,-1,1,-2 });
	}

}
