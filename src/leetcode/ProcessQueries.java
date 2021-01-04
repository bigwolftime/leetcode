package leetcode;

import java.util.LinkedList;

/**
 * 查询带键的排列
 * https://leetcode-cn.com/problems/queries-on-a-permutation-with-key/
 */
public class ProcessQueries {

    private static int[] processQueries(int[] queries, int m) {
        int[] arr = new int[queries.length];

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int idx = list.indexOf(query);

            arr[i] = idx;

            list.remove(idx);
            list.add(0, query);
        }

        return arr;
    }

    public static void main(String[] args) {

    }

}
