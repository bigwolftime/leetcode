package leetcode;

import java.util.List;

/**
 * 找到 K 个最接近的元素
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 */
public class FindClosestElements {

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);

        int[] resArr = new int[k];

        return null;
    }

    /**
     * 二分
     * @param arr
     * @param x
     * @return
     */
    private static int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int mid;

        while (l + 1 < r) {
            mid = l + ((r - l) >> 1);

            if (arr[mid] > x) {
                r = mid - 1;
            } else if (arr[mid] < x) {
                l = mid;
            } else {
                return mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {

    }

}
