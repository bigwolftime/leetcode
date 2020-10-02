package leetcode;

import java.util.HashSet;

/**
 * 宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class NumJewelsInStones {

	private static int numJewelsInStones(String J, String S) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < J.length(); i++) {
			set.add(J.charAt(i));
		}

		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			if (set.contains(S.charAt(i))) {
				count++;
			}
		}

		return count;
	}

	public static void main (String[] args) {

	}

}
