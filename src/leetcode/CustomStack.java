package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个支持增量操作的栈
 * https://leetcode-cn.com/problems/design-a-stack-with-increment-operation/
 *
 * @author liuxin
 * @time 2020/10/22 15:22
 */
public class CustomStack {

    private final List<Integer> list;
    private final int maxSize;

    public CustomStack(int maxSize) {
        this.list = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (list.size() >= maxSize) {
            return;
        }

        list.add(x);
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(list.size() - 1);
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < list.size(); i++) {
            list.set(i, list.get(i) + val);
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(3);
        customStack.push(1);
        System.err.println(customStack.pop());;
    }

}
