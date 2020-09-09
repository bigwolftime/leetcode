package leetcode;

import java.util.*;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * 1. 堆排序
 * 2. 搞了一个类, 做字段排序...
 */
public class TopKFrequent {

	private static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> countMap = new HashMap<>();

		Integer count;
		for (int i : nums) {
			count = countMap.get(i);

			if (count == null) {
				countMap.put(i, 1);
			} else {
				countMap.put(i, countMap.get(i) + 1);
			}
		}

		List<Counter> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			list.add(new Counter(entry.getKey(), entry.getValue()));
		}

		list.sort(Comparator.comparingInt(counter -> counter.count));
		int[] arr = new int[k];
		int index = k - 1;

		for (; k > 0; k--) {
			arr[index--] = list.get(list.size() - k).val;
		}

		return arr;
	}

	private static class Counter {
		int val;
		int count;

		public Counter(){}
		public Counter(int val, int count) {
			this.val = val;
			this.count = count;
		}
	}

	public static void main (String[] args) {
		/*PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		priorityQueue.add(3);
		priorityQueue.add(2);
		priorityQueue.add(4);


		System.err.println(priorityQueue);*/
		topKFrequent(new int[]{ 1,1,1,2,2,3 }, 2);
	}

}
