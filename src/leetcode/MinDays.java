package leetcode;

import java.util.HashMap;

/**
 * 吃掉 N 个橘子的最小天数
 * https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges/
 *
 * 动态规划, 然额超时, 需要考虑缓存或者其他办法
 */
public class MinDays {

	private static int minDays(int n) {
		return eat(n, 0, new HashMap<>());
	}

	private static int eat(int n, int count, HashMap<Integer, Integer> map) {
		if (n <= 0) {
			return count;
		}

		if (map.containsKey(n)) {
			return map.get(n);
		}

		int x;
		boolean mod_2 = n % 2 == 0;
		boolean mod_3 = n % 3 == 0;
		count++;

		if (mod_2 && mod_3) {
			x = Math.min(eat(n - (n >> 1), count, map), eat(n - 2 * (n / 3), count, map));
			x = Math.min(x, eat(n - 1, count, map));
			map.put(n, x);
			return x;
		}

		if (mod_2) {
			x = Math.min(eat(n - (n >> 1), count, map), eat(n - 1, count, map));
			return x;
		}
		if (mod_3) {
			x = Math.min(eat(n - 2 * (n / 3), count, map), eat(n - 1, count, map));
			return x;
		}

		x = eat(n - 1, count, map);
		return x;
	}

	public static void main (String[] args) {
		System.err.println(minDays(182));
	}

}
