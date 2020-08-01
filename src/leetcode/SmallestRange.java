package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小区间
 * https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
 *
 * 使用多指针. 准备两个数组, 一个用来存放每组数据的索引(即遍历到了哪个位置), 另一个数组存储对应的 value.
 * 每次会查询出最小值与最大值, 与上一次作比较.
 *
 * 其中查找最大值的方法, 可以使用堆排序优化.
 *
 * @author liuxin
 * @date 2020/8/1 16:55
 */
public class SmallestRange {

    private static int[] smallestRange(List<List<Integer>> nums) {
        // 使用多指针.

        // 准备两个数组. pointArr 存储每组数据的索引, dataArr 存储指向所对应的值
        int[] dataArr = new int[nums.size()], pointArr = new int[nums.size()];
        // dataArr 中最小值的索引
        int minIdx;

        // 初始化工作
        for (int i = 0; i < nums.size(); i++) {
            dataArr[i] = nums.get(i).get(pointArr[i]);
        }

        // 记录数组左右边界
        int left = 0, right = Integer.MAX_VALUE;

        int curLeft, curRight;
        List<Integer> curList;
        while (true) {
            Pair<Integer, Integer> pair = getIdx(dataArr);
            minIdx = pair.getKey();

            curList = nums.get(minIdx);

            // 获取极值
            curLeft = dataArr[pair.getKey()];
            curRight = dataArr[pair.getValue()];

            if (curRight - curLeft < right - left) {
                left = curLeft;
                right = curRight;
            }

            pointArr[minIdx]++;
            if (pointArr[minIdx] >= curList.size()) {
                break;
            }

            dataArr[minIdx] = curList.get(pointArr[minIdx]);
        }

        System.err.println(left + "," + right);

        return new int[]{ left, right };
    }

    private static Pair<Integer, Integer> getIdx(int[] dataArr) {
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < dataArr.length; i++) {
            if (dataArr[i] < dataArr[minIdx]) {
                minIdx = i;
            } else if (dataArr[i] > dataArr[maxIdx]) {
                maxIdx = i;
            }
        }

        return new Pair<>(minIdx, maxIdx);
    }

    public static void main(String[] args) {
        int[] aArr = new int[]{ 4,10,15,24,26 };
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < aArr.length;  i++) {
            a.add(aArr[i]);
        }

        int[] bArr = new int[]{ 0,9,12,20 };
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < bArr.length; i++) {
            b.add(bArr[i]);
        }

        int[] cArr = new int[]{ 5,18,22,30 };
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < cArr.length; i++) {
            c.add(cArr[i]);
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        smallestRange(list);
    }

}
