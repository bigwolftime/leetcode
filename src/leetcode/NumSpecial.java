package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 二进制矩阵中的特殊位置
 * https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix/
 */
public class NumSpecial {

	private static int numSpecial(int[][] mat) {
		HashSet<Integer> xSet = new HashSet<>(), xRepeatSet = new HashSet<>();
		HashSet<Integer> ySet = new HashSet<>(), yRepeatSet = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {

				if (mat[i][j] == 1) {
					boolean xRepeat = xSet.contains(i);
					boolean yRepeat = ySet.contains(j);
					if (xRepeat) {
						xRepeatSet.add(i);
					} else {
						xSet.add(i);
					}

					if (yRepeat) {
						yRepeatSet.add(j);
					} else {
						ySet.add(j);
					}

					if (!xRepeat && !yRepeat) {
						list.add(i);
						list.add(j);
					}
				}
			}
		}

		xSet.removeAll(xRepeatSet);
		ySet.removeAll(yRepeatSet);
		int count = 0;

		for (int i = 0; i < list.size(); i += 2) {
			if (xSet.contains(list.get(i)) && ySet.contains(list.get(i + 1))) {
				count++;
			}
		}

		return count;
	}

	public static void main (String[] args) {

	}

}
