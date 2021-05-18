package newcode;

import utils.ArrayUtil;

/**
 * 递归分治的思想.
 *
 * 随机选择一个数, 将 < 此数放在左边, > 此数的放在右边, = 放中间. 两侧部分继续此递归逻辑
 *
 * 时间复杂度: O(NlogN)
 * 空间复杂度:
 *
 * 不能保证排序稳定性
 *
 * @author liuxin
 * @time 2020/11/4 14:19
 */
public class QuickSort {

    public static void main(String[] args) {

    }


    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int num = arr[low];

        while (low < high) {
            while (low < high && arr[high] > num) {
                high--;
            }
            ArrayUtil.swap(arr, low, high);//交换后，基准值跑到高位较小的位置了
            while (low < high && arr[low] <= num) {
                low++;
            }
            ArrayUtil.swap(arr, low, high);//交换后，基准值又跑到低位较大位置了
        }
        return low;
    }

}
