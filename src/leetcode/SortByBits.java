package leetcode;

import java.util.Arrays;

/**
 * 根据数字二进制下 1 的数目排序
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 *
 * 1. 将数组按大小排序;
 * 2. 使用对象封装, 根据 counter 排序(堆排序保证稳定性)
 *
 * @author liuxin
 * @time 2020/11/6 9:29
 */
public class SortByBits {

    private static int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        Counter[] counterArr = new Counter[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int val = arr[i];
            int originVal = val;

            while (val != 0) {
                if (val % 2 != 0) {
                    count++;
                }

                val /= 2;
            }

            counterArr[i] = new Counter(originVal, count);
        }

        mergeSort(counterArr, 0, arr.length - 1);

        int[] resArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            resArr[i] = counterArr[i].num;
        }

        return resArr;
    }

    private static void mergeSort(Counter[] counterArr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        mergeSort(counterArr, l, mid);
        mergeSort(counterArr, mid + 1, r);
        merge(counterArr, l, mid, r);
    }

    private static void merge(Counter[] counterArr, int l, int mid, int r) {
        int p = l, q = mid + 1;
        int idx = 0;
        Counter[] tempArr = new Counter[r - l + 1];

        while (p <= mid && q <= r) {
            if (counterArr[p].count <= counterArr[q].count) {
                tempArr[idx++] = counterArr[p++];
            } else if (counterArr[p].count > counterArr[q].count) {
                tempArr[idx++] = counterArr[q++];
            }
        }
        while (p <= mid) {
            tempArr[idx++] = counterArr[p++];
        }
        while (q <= r) {
            tempArr[idx++] = counterArr[q++];
        }

        if (tempArr.length >= 0) System.arraycopy(tempArr, 0, counterArr, l, tempArr.length);
    }

    private static class Counter {
        int num;
        int count;

        public Counter(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        //sortByBits(new int[]{ 1024,512,256,128,64,32,16,8,4,2,1 });
        System.err.println(Integer.toBinaryString(1024));
    }

}
