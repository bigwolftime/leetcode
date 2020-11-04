package newcode;

import utils.ArrayUtil;

/**
 * 插入排序
 *
 * 默认第 1 个位置已排序, 从未排序的序列中选择第一个, 插入到已排序序列中合适的位置
 * 判断: arr[index] < arr[index - 1] -> 交换(循环)
 *
 * 时间复杂度: O(N ^ 2)
 * 空间复杂度: O(1)
 *
 * @author liuxin
 * @time 2020/11/4 11:57
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,3,5,7,9,2,4,6,8,0 };

        for (int i = 1; i < arr.length; i++) {
            int j = i + 1;

            while (j >= 1 && j <arr.length && arr[j] < arr[j - 1]) {
                ArrayUtil.swap(arr, j, j - 1);
                j--;
            }
        }

        System.err.println("");

    }

}
