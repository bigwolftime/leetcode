package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 可被 5 整除的二进制前缀
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 *
 * 从左向右遍历，每次等于当前的 sum *= 2. 如果当前位为 1，则自增
 */
public class PrefixesDivBy5 {

    private static List<Boolean> prefixesDivBy5(int[] A) {
        int sum = 0;
        List<Boolean> list = new ArrayList<>();

        for (int val : A) {
            sum *= 2;

            if (val == 1) {
                sum++;
            }

            list.add(sum % 5 == 0);

            if (sum >= 10) {
                sum %= 10;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        prefixesDivBy5(new int[]{});
    }

}
