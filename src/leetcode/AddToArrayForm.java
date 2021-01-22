package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组形式的整数加法
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 */
public class AddToArrayForm {

    private static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();

        int i = A.length - 1;
        boolean flag = false;
        int tmp;

        for (; i >= 0; i--) {
            tmp = K % 10;
            K /= 10;

            int sum = A[i] + tmp;

            if (flag) {
                sum++;
                flag = false;
            }

            if (sum >= 10) {
                flag = true;
                sum %= 10;
            }

            list.add(0, sum);
        }

        while (K != 0) {
            tmp = K % 10;
            K /= 10;

            if (flag) {
                tmp++;
                flag = false;
            }
            if (tmp >= 10) {
                tmp %= 10;
                flag = true;
            }

            list.add(0, tmp);
        }

        if (flag) {
            list.add(0, 1);
        }

        return list;
    }

    public static void main(String[] args) {
        addToArrayForm(new int[]{ 2,1,5 }, 806);
    }

}
