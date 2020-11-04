package newcode;

import utils.ArrayUtil;

/**
 * 选择排序
 *
 * 首先从 0, n-1 选择一个最小的, 与 0 位置交换;
 * 从 1, n-1 选择一个最小的, 与 1 位置交换...
 *
 * 时间复杂度: O(N ^ 2)
 * 空间复杂度: O(1)
 *
 * 可以保证排序稳定性.
 *
 * @author liuxin
 * @time 2020/11/4 11:48
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,3,5,7,9,2,4,6,8,0 };

        for (int i = 0; i < arr.length; i++) {

            int minIdx = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            ArrayUtil.swap(arr, minIdx, i);
        }

        System.err.println("");
    }

}
