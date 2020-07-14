package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author liuxin
 * @date 2020/7/14 8:15
 */
public class MinimumTotal {

    private static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> curList = triangle.get(0), prevList = triangle.get(0);
        int prevX, prevY;

        for (int x = 1; x < triangle.size(); x++) {
            curList = triangle.get(x);

            for (int y = 0; y < x + 1; y++) {
                if (y == 0) {
                    prevX = 0;
                    prevY = 0;
                } else if (y == x) {
                    prevX = x - 1;
                    prevY = x - 1;
                } else {
                    prevX = y - 1;
                    prevY = y;
                }

                curList.set(y, Math.min(prevList.get(prevX), prevList.get(prevY)) + curList.get(y));
            }

            prevList = curList;
        }

        int min = Integer.MAX_VALUE;
        for (int i : curList) {
            min = Math.min(i, min);
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> tmpList1 = new ArrayList<>();
        tmpList1.add(2);
        list.add(tmpList1);

        List<Integer> tmpList2 = new ArrayList<>();
        tmpList2.add(3);
        tmpList2.add(4);
        list.add(tmpList2);

        List<Integer> tmpList3 = new ArrayList<>();
        tmpList3.add(6);
        tmpList3.add(5);
        tmpList3.add(7);
        list.add(tmpList3);

        List<Integer> tmpList4 = new ArrayList<>();
        tmpList4.add(4);
        tmpList4.add(1);
        tmpList4.add(8);
        tmpList4.add(3);
        list.add(tmpList4);

        minimumTotal(list);
    }

}
