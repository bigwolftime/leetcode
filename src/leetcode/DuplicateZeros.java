package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复写 0<br/>
 * <a href="https://leetcode.cn/problems/duplicate-zeros/">...</a>
 *
 * @author liuxin
 * @date 2024/2/19 16:50
 */
public class DuplicateZeros {

    private static void duplicateZeros(int[] arr) {
        int len = arr.length;
        List<Integer> list = new ArrayList<>();

        for (int val : arr) {
            if (list.size() == len) {
                break;
            }

            if (val == 0) {
                list.add(0);
                list.add(0);
            } else {
                list.add(val);
            }
        }

        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{ 1,0,2,3,0,4,5,0 };
        duplicateZeros(arr);
    }

}
