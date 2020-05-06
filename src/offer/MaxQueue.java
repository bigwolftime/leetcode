package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * 1. 使用 list: push_back() 直接调用 add(), max_value() 需要遍历;
 * 2. 构造双端队列
 */
public class MaxQueue {

    // 解法 1:
    /*private List<Integer> list;

    public MaxQueue() {
        list = new ArrayList<>();
    }

    public int max_value() {
        int max = -1;
        for (int i : list) {
            max = Math.max(max, i);
        }
        return max;
    }

    public void push_back(int value) {
        list.add(value);
    }

    public int pop_front() {
        if (list.isEmpty()) {
            return -1;
        }

        return list.remove(0);
    }*/


    // 解法 2:
    private List<Integer> list;
    private List<Integer> maxList;

    public MaxQueue() {
        list = new ArrayList<>();
        maxList = new ArrayList<>();
    }

    public int max_value() {
        if (!maxList.isEmpty()) {
            return maxList.get(0);
        }

        return -1;
    }

    public void push_back(int value) {
        list.add(value);

        int lastIdx, tail;
        while (!maxList.isEmpty()) {
            lastIdx = maxList.size() - 1;
            tail = maxList.get(lastIdx);
            if (value > tail) {
                maxList.remove(lastIdx);
            } else {
                break;
            }
        }

        maxList.add(value);
    }

    public int pop_front() {
        if (list.isEmpty()) {
            return -1;
        }

        int remove = list.remove(0);
        if (maxList.get(0) <= remove) {
            maxList.remove(0);
        }

        return remove;
    }



    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(4);
        queue.push_back(5);
        queue.push_back(2);
        queue.push_back(6);
        queue.push_back(1);
    }

}
