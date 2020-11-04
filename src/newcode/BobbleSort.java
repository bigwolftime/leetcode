package newcode;

import utils.ArrayUtil;

/**
 * 冒泡排序
 *
 * 时间复杂度: O(N ^ 2)
 * 空间复杂度: O(1)
 *
 * 可以保证排序稳定性
 *
 * @author liuxin
 * @time 2020/11/4 11:45
 */
public class BobbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,3,5,7,9,2,4,6,8,0 };

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    ArrayUtil.swap(arr, i, j);
                }

            }
        }


        System.err.println("x");
    }

}
