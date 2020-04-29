package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * 获取最大值的事件复杂度为: O(n)
 * 均摊复杂度不符合
 */
public class MaxQueue {

    private List<Integer> list;

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
    }


    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        queue.pop_front();
        queue.max_value();
    }

}
