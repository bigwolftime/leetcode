package leetcode;

import java.util.*;

/**
 * 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * @author liuxin
 * @time 2020/5/25 20:50
 */
public class CanFinish {

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // 构造数据
        int k, v;
        for (int[] arr : prerequisites) {
            k = arr[0];
            v = arr[1];

            // 计数 map
            if (!countMap.containsKey(k)) {
                countMap.put(k, 0);
            }
            if (countMap.get(v) == null) {
                countMap.put(v, 1);
            } else {
                countMap.put(v, countMap.get(v) + 1);
            }

            // 指向节点map
            if (edgeMap.containsKey(k)) {
                edgeMap.get(k).add(v);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(v);

                edgeMap.put(k, list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        int curNode;
        Integer count;

        while (!queue.isEmpty()) {
            curNode = queue.poll();

            List<Integer> edgeList = edgeMap.get(curNode);
            if (edgeList != null) {
                for (Integer node : edgeList) {
                    count = countMap.get(node);
                    if (count != null) {
                        count--;
                        countMap.put(node, count);

                        if (count == 0) {
                            queue.add(node);
                        }
                    }

                }
            }

            countMap.remove(curNode);
        }

        return countMap.isEmpty();
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                /*{2, 1},
                {2, 3},
                {1, 3},
                {1, 5},
                {6, 5},
                {4, 6},
                {6, 7},
                {1, 6}*/


                {0,2},
                {1,2},
                {2,0}

                /*{1,0},
                {0,1}*/

                //{1,0}
        };
        boolean b = canFinish(7, nums);

        System.err.println(b);
    }

}
