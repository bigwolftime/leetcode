package offer;

import utils.MountainArray;

/**
 * 山脉数组中查找目标值
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 */
public class FindInMountainArray {

    private static int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        // 寻找峰值
        int start = 0, end = length - 1;
        int mid = (start + end) / 2;
        int p = mountainArr.get(mid), q = mountainArr.get(mid + 1);

        while (start < end) {
            if (p < q) {
                // 峰值在右
                start = mid + 1;
            } else {
                // 峰值在左
                end = mid;
            }

            mid = (start + end) / 2;
            p = mountainArr.get(mid);
            q = mountainArr.get(mid + 1);
        }

        // 峰值下标
        int maxIdx = mountainArr.get(start) > mountainArr.get(end) ? start : end;

        // 峰值左区间寻找目标
        int targetIdx = binaryQuery(mountainArr, target, 0, maxIdx, 1);
        if (targetIdx != -1) {
            return targetIdx;
        }

        // 左区间没有找到, 在右区间寻找
        return binaryQuery(mountainArr, target, maxIdx, length - 1, -1);
    }

    private static int binaryQuery(MountainArray mountainArr, int target, int start, int end, int order) {
        int val, mid;
        while (start < end) {
            mid = (start + end) / 2;
            val = mountainArr.get(mid);
            if (val < target) {
                if (order == 1) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else if (val > target) {
                if (order == 1) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                // 相等
                return mid;
            }
        }

        if (start == end) {
            return mountainArr.get(start) == target ? start : -1;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[] { 0,1,2,4,2,1 };
        MountainArray mountainArray = new MountainArray(arr);
        System.err.println(findInMountainArray(3, mountainArray));
    }

}
