package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 */
public class MaxQueue {

    private Queue<Integer> dataQueue;
    private Queue<Integer> maxQueue;

    public MaxQueue() {
        dataQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }

        return maxQueue.peek();
    }

    /*public void push_back(int value) {
        dataQueue.add(value);

        if (maxQueue.isEmpty()) {
            maxQueue.add(value);
        } else {
            maxQueue.
        }
    }

    public int pop_front() {
        if (dataQueue.isEmpty()) {
            return -1;
        }

        int poll = dataQueue.poll();

        while (maxQueue.peek())
    }


    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        queue.pop_front();
        queue.max_value();
    }*/

}
