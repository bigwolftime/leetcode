package alg4;

/**
 * @author Liuxin
 * @since 2019/9/2 14:51
 * 首先找到数组中最小的元素，和第一个交换位置(如果第一个元素最小，那么与自己交换)。
 * 在剩下的元素中找到最小的，与第二个位置交换...
 */
public class SelectSort {

    public static void selectSort(int[] arr) {
        int start = 0;
        int tempStart, minPos;
        while (start < arr.length) {
            minPos = tempStart = start;
            while (tempStart < arr.length) {
                if (arr[tempStart] <= arr[minPos]) {
                    minPos = tempStart;
                }
                tempStart++;
            }

            //交换
            temp(arr, start, minPos);

            start++;
        }

        for (int i : arr) {
            System.err.println(i);
        }

    }

    private static void temp(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 5, 3, 1, 2, 4, 6, 8, 10};
        selectSort(arr);
    }

}
