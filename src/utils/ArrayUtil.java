package utils;

/**
 * @author liuxin
 * @time 2020/11/4 11:46
 */
public class ArrayUtil {

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
