package leetcode;

import java.util.*;

/**
 * 寻找图中是否存在路径
 * https://leetcode.cn/problems/find-if-path-exists-in-graph/
 *
 * @author liuxin
 * @date 2022/12/19 09:34
 */
public class ValidPath {

    private static Set<Integer> PATH_SET;
    private static boolean FLAG;


    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) {
            return true;
        }

        PATH_SET = new HashSet<>();
        FLAG = false;

        Map<Integer, List<Integer>> edgesMap = toMap(edges);

        dfs(edgesMap, source, destination);

        return FLAG;
    }

    private static Map<Integer, List<Integer>> toMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> list1 = map.get(edge[0]);
            if (list1 == null) {
                list1 = new ArrayList<>();
                list1.add(edge[1]);
                map.put(edge[0], list1);
            } else {
                list1.add(edge[1]);
            }

            List<Integer> list2 = map.get(edge[1]);
            if (list2 == null) {
                list2 = new ArrayList<>();
                list2.add(edge[0]);
                map.put(edge[1], list2);
            } else {
                list2.add(edge[0]);
            }
        }

        return map;
    }

    private static void dfs(Map<Integer, List<Integer>> map, int source, int destination) {
        List<Integer> nextPathList = map.get(source);
        if (nextPathList == null || nextPathList.isEmpty()) {
            // nextPath not available -> return
            return;
        }

        if (PATH_SET.contains(source)) {
            // cur traversed -> return
            return;
        }

        PATH_SET.add(source);

        for (Integer next : nextPathList) {
            if (next == destination) {
                FLAG = true;
                return;
            }

            dfs(map, next, destination);
        }
    }


    public static void main(String[] args) {
        validPath(6, new int[][]{
                {0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}
        }, 0, 5);
    }
}
