package newcode;

/**
 * 归并排序
 *
 * 递归 分治的思想, 先找到中点 mid, 把 mid 两边排好, 然后外排
 *
 * 时间复杂度: O(NlogN)
 * 空间复杂度: O(N)      因为使用到了辅助数组
 *
 * 可以保证排序稳定性
 *
 * @author liuxin
 * @time 2020/11/4 14:19
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,3,5,7,9,2,4,6,8,0 };
        mergeSort(arr, 0, arr.length - 1);

        System.err.println("");
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            // 停止条件
            return;
        }

        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        // 辅助数据, 双指针 外排
        int[] tempArr = new int[r - l + 1];
        int index = 0;
        int p = l, q = mid + 1;

        while (p <= mid && q <= r) {

            if (arr[p] < arr[q]) {
                tempArr[index++] = arr[p++];
            } else if (arr[p] > arr[q]) {
                tempArr[index++] = arr[q++];
            } else {
                tempArr[index++] = arr[p++];
                tempArr[index++] = arr[q++];
            }
        }
        while (p <= mid) {
            tempArr[index++] = arr[p++];
        }
        while (q <= r) {
            tempArr[index++] = arr[q++];
        }

        // 复制回原数组
        if (tempArr.length >= 0) System.arraycopy(tempArr, 0, arr, l, tempArr.length);
    }

}
