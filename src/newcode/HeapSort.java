package newcode;


import utils.ArrayUtil;

/**
 * 理解为一个完全二叉树
 *
 * 首先构建一个堆(例如: 大根堆), 构建完成后已知当前最大的数字即堆顶.
 * 然后堆顶与最后一个元素交换, 此时拿到最大值, 由于交换后的堆顶可能不符合堆的特性, 所以需继续与左右还在比较, 交换.
 *
 * 每插入一个新元素, 最多比较交换树的高度(即 logN)
 * 时间复杂度: O(NlogN)
 * 空间复杂度: O(1)
 *
 * 无法保证排序稳定性
 *
 * @author liuxin
 * @time 2020/11/4 14:43
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{ 3,5,1,2,6,9,7,8,4,0 };

        for (int i = 0; i < arr.length; i++) {
            heapBuild(arr, i);
        }

        int heapSize = arr.length;

        while (heapSize > 0) {
            ArrayUtil.swap(arr, 0, --heapSize);
            heapSort(arr, heapSize);
        }

        System.err.println("x");
    }

    private static void heapBuild(int[] arr, int index) {
        int parentIndex = (index - 1) / 2;

        while (arr[index] > arr[parentIndex]) {
            ArrayUtil.swap(arr, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private static void heapSort(int[] arr, int heapSize) {
        int maxChildIndex;
        int leftChildIndex;
        int index = 0;

        while (index < heapSize && (leftChildIndex = 2 * index + 1) < heapSize) {
            maxChildIndex = leftChildIndex;
            int rightChildIndex;
            if (((rightChildIndex = 2 * index + 2) < heapSize) && arr[rightChildIndex] > arr[leftChildIndex]) {
                maxChildIndex = rightChildIndex;
            }

            if (arr[index] >= arr[maxChildIndex]) {
                break;
            }

            ArrayUtil.swap(arr, index, maxChildIndex);
            index = maxChildIndex;
        }
    }

}
