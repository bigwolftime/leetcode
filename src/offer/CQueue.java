package offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * 用了一个 flag 标记数据存储在哪一个栈中, 若在 stack1 则 可直接 push, 不能直接 pop; 若在 stack2 则可直接 pop, 不能直接 push
 *
 * @author liuxin
 * @date 2020/6/30 6:57
 */
public class CQueue {

    private Stack<Integer> dataStack1;
    private Stack<Integer> dataStack2;
    private boolean flag;

    public CQueue() {
        dataStack1 = new Stack<>();
        dataStack2 = new Stack<>();
        flag = true;
    }

    public void appendTail(int value) {
        if (!flag) {
            while (!dataStack2.isEmpty()) {
                dataStack1.push(dataStack2.pop());
            }

            flag = true;
        }

        dataStack1.push(value);
    }

    public int deleteHead() {
        if (flag) {
            if (dataStack1.isEmpty()) {
                return -1;
            }

            while (!dataStack1.isEmpty()) {
                dataStack2.push(dataStack1.pop());
            }

            flag = false;

            return dataStack2.pop();
        }

        if (dataStack2.isEmpty()) {
            return -1;
        }

        return dataStack2.pop();
    }

}
