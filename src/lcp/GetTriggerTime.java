package lcp;

/**
 * 剧情触发时间
 * https://leetcode-cn.com/problems/ju-qing-hong-fa-shi-jian/
 * <p>
 * 准备 3 个数组 cArr, rArr, hArr, 每个数组大小 increase.length 容量.
 * 计算 increase 每列的加和填充到数组. 空间复杂度 O(n)
 * 那么就转变成二分查找. 时间复杂度: 3 * m * logN = O(m * logN) (m: requirements 数组长度, n: increase 长度)
 * <p>
 * OJ 未通过, 但是找不出是啥问题... 同样的数据和我的就是不一样.
 *
 * @author liuxin
 * @time 2020/6/17 18:49
 */
public class GetTriggerTime {

    private static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int dataLen = increase.length;
        int[] cArr = new int[dataLen], rArr = new int[dataLen], hArr = new int[dataLen];
        cArr[0] = increase[0][0];
        rArr[0] = increase[0][1];
        hArr[0] = increase[0][2];

        int[] incrArr;
        for (int i = 1; i < increase.length; i++) {
            incrArr = increase[i];
            cArr[i] += cArr[i - 1] + incrArr[0];
            rArr[i] += rArr[i - 1] + incrArr[1];
            hArr[i] += hArr[i - 1] + incrArr[2];
        }

        int[] res = new int[requirements.length];

        int day;
        int[] tempArr;
        int index;
        for (int i = 0; i < requirements.length; i++) {
            day = 0;
            tempArr = requirements[i];

            index = binarySearch(cArr, tempArr[0]);
            if (index < 0) {
                res[i] = -1;
                continue;
            }
            day = Math.max(day, index);

            index = binarySearch(rArr, tempArr[1]);
            if (index < 0) {
                res[i] = -1;
                continue;
            }
            day = Math.max(day, index);

            index = binarySearch(hArr, tempArr[2]);
            if (index < 0) {
                res[i] = -1;
                continue;
            }
            day = Math.max(day, index);

            res[i] = day;
        }

        return res;
    }

    private static int binarySearch(int[] arr, int target) {
        if (target == 0) {
            return 0;
        }

        int start = 0, end = arr.length - 1;
        int mid, temp;

        while (start < end) {
            mid = start + (end - start) / 2;
            temp = arr[mid];

            if (temp > target) {
                end = mid;
            } else if (temp < target) {
                start = mid + 1;
            } else {
                // 相等, 则向前探测相等的情况
                while (mid - 1 >= 0 && arr[mid - 1] == temp) {
                    mid--;
                }

                return mid + 1;
            }
        }

        if (target > arr[start]) {
            start++;
        }

        return start >= arr.length || arr[start] < target ? -1 : start + 1;
    }

    public static void main(String[] args) {
        int[][] increase = new int[][]{
                {4, 0, 8}, {7, 7, 10}, {7, 9, 8}, {3, 10, 1}, {8, 6, 8}, {2, 2, 0}, {4, 10, 8}, {1, 5, 4}, {4, 4, 10}, {7, 9, 8}, {
                3, 8, 6}, {0, 0, 6}, {3, 2, 9}, {4, 0, 9}, {4, 8, 9}, {0, 8, 2}, {5, 7, 10}, {7, 10, 6}, {1, 4, 6}, {3, 10, 0}, {8, 2, 5}, {
                3, 1, 0}, {7, 0, 7}, {9, 10, 3}, {2, 4, 2}, {2, 3, 4}, {0, 7, 7}, {0, 9, 4}, {9, 3, 7}, {1, 10, 7}, {2, 7, 2}, {3, 9, 2}, {
                0, 9, 7}, {1, 9, 10}, {3, 2, 8}, {9, 9, 5}, {5, 9, 7}, {1, 2, 9}, {10, 5, 7}, {10, 2, 6}, {8, 0, 10}, {7, 9, 5}, {6, 10, 3}, {
                1, 7, 0}, {8, 2, 2}, {3, 3, 6}, {0, 4, 8}, {8, 0, 1}, {7, 0, 6}, {6, 3, 6}, {6, 0, 1}, {3, 10, 6}, {9, 3, 0}, {9, 4, 3}, {
                8, 1, 6}, {10, 9, 0}, {4, 5, 10}, {2, 9, 6}, {8, 2, 5}, {6, 9, 3}, {1, 2, 1}, {3, 8, 2}, {7, 9, 4}, {8, 6, 7}, {10, 5, 8}, {
                2, 6, 2}, {3, 6, 9}, {4, 1, 6}, {8, 10, 6}, {3, 2, 1}, {0, 8, 7}, {4, 6, 4}, {3, 4, 8}, {3, 4, 9}, {2, 8, 3}, {6, 8, 9}, {
                8, 5, 0}, {9, 9, 7}, {1, 7, 4}, {8, 7, 3}, {0, 9, 3}, {3, 8, 10}, {4, 7, 9}, {8, 8, 7}, {9, 6, 9}, {8, 0, 5}, {0, 4, 3}, {
                5, 10, 3}, {9, 6, 4}
        };

        int[][] requirements = new int[][]{
                {99, 92, 57},{53, 76, 42},{81, 18, 36},{34, 76, 33},{55, 97, 77},{19, 41, 94},{82, 49, 99},{97, 58, 24},{
        66, 47, 50},{15, 86, 67},{43, 71, 80},{83, 29, 16},{21, 101, 57},{19, 34, 22},{12, 30, 35},{96, 89, 94},{
        42, 89, 89},{87, 98, 43},{82, 95, 68},{97, 17, 83},{100, 87, 19},{99, 74, 73},{87, 47, 54},{66, 11, 16},{
        86, 96, 21},{63, 42, 25},{65, 35, 27},{98, 32, 88},{54, 32, 91},{24, 15, 34},{19, 44, 16},{40, 95, 81},{
        42, 52, 92},{64, 88, 58},{33, 51, 39},{40, 26, 66},{74, 88, 96},{46, 98, 83},{42, 60, 31},{39, 72, 85},{
        65, 90, 34},{31, 24, 44},{81, 11, 27},{34, 97, 60},{98, 54, 10},{13, 33, 42},{58, 95, 10},{46, 50, 59},{
        45, 71, 40},{11, 52, 11},{56, 27, 24},{85, 41, 72},{10, 34, 56},{99, 38, 77},{21, 80, 100},{50, 52, 100},{
        61, 55, 57},{100, 83, 36},{71, 84, 65},{29, 86, 35},{77, 61, 49},{76, 41, 98},{37, 99, 79},{99, 73, 86}
        };

        int[] triggerTime = getTriggerTime(increase, requirements);
        for (int i : triggerTime) {
            System.err.print(i + " ");
        }
    }

}
