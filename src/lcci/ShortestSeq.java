package lcci;

import java.util.*;

/**
 * 最短超串
 * https://leetcode-cn.com/problems/shortest-supersequence-lcci/
 */
public class ShortestSeq {

	private static int[] shortestSeq1(int[] big, int[] small) {
		int[] resArr = new int[]{ 0, big.length };
		List<Integer> list = new ArrayList<>();
		HashSet<Integer> valSet = new HashSet<>();

		HashSet<Integer> set = new HashSet<>();
		for (int val : small) {
			set.add(val);
		}

		int firstIdx;
		for (int i = 0; i < big.length; i++) {
			if (set.contains(big[i])) {
				list.add(i);
				valSet.add(big[i]);

				while (valSet.size() == small.length) {
					if (i - (firstIdx = list.get(0)) < resArr[1] - resArr[0]) {
						resArr[0] = firstIdx;
						resArr[1] = i;
					}

					list.remove(0);

					valSet.clear();
					for (int j : list) {
						valSet.add(big[j]);
					}
				}
			}
		}

		return resArr[1] != big.length ? resArr : new int[0];
	}

	private static int[] shortestSeq(int[] big, int[] small) {
		int[] resArr = new int[]{ 0, big.length };

		HashSet<Integer> set = new HashSet<>();
		for (int val : small) {
			set.add(val);
		}

		List<Integer> idxList = new ArrayList<>();
		List<Integer> valList = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		Integer count;
		int val, firstVal;
		for (int i = 0; i < big.length; i++) {
			val = big[i];

			if (set.contains(val)) {
				idxList.add(i);
				valList.add(val);

				count = map.get(val);
				if (count != null) {
					map.put(val, count + 1);
					continue;
				}

				map.put(val, 1);

				while (map.size() == small.length) {
					if (i - idxList.get(0) < resArr[1] - resArr[0]) {
						resArr[0] = idxList.get(0);
						resArr[1] = i;
					}

					// 移除首位元素
					firstVal = valList.remove(0);
					count = map.get(firstVal);
					if (count == 1) {
						map.remove(firstVal);
					} else {
						map.put(firstVal, count - 1);
					}

					idxList.remove(0);
				}
			}
		}

		return resArr[1] != big.length ? resArr : new int[0];
	}

	public static void main (String[] args) {
		shortestSeq(new int[]{ 1,2,1,3 }, new int[]{ 1,2,3 });
	}

}
