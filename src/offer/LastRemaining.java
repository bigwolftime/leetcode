package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * todo
 */
public class LastRemaining {

    private static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int p = 0;
        int count = m;
        while (list.size() > 1) {
            if (p >= list.size()) {
                p = 0;
                count--;
            }

            if (p == m) {
                count = m;
                list.remove(p - 1);
            }

            p++;
            count--;
        }

        return -1;
    }

    public static void main(String[] args) {
        lastRemaining(5,3);
    }

}
