package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * n 的第 k 个因子
 * https://leetcode-cn.com/problems/the-kth-factor-of-n/
 *
 * 双周赛 29 第二题
 *
 * @author liuxin
 * @time 2020/6/28 15:43
 */
public class KthFactor {

    private static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n >> 1; i++) {
            // 只循环到 n 的一半即可

            if (n % i == 0) {
                list.add(i);

                if (list.size() >= k) {
                    return list.get(list.size() - 1);
                }
            }
        }

        // 最后把 n 加到 list
        list.add(n);

        return list.size() >= k ? list.get(list.size() - 1) : -1;
    }

    public static void main(String[] args) {
        System.err.println(kthFactor(4,1));;
    }

}
