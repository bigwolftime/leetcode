package leetcode;

import java.util.BitSet;

/**
 * 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 *
 * 厄拉多塞 算法.
 *
 * @author liuxin
 * @time 2020/6/23 16:47
 */
public class CountPrimes {

    private static int countPrimes(int n) {
        BitSet bitSet = new BitSet();

        for (int i = 2; i < n; i++) {
            if (!bitSet.get(i)) {
                for (int j = i << 1; j < n; j += i) {
                    bitSet.set(j);
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!bitSet.get(i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.err.println(countPrimes(10));
    }

}
