package lcci;

import java.util.Stack;

/**
 * 栈的最小值
 * https://leetcode-cn.com/problems/min-stack-lcci/
 *
 * @author liuxin
 * @time 2020/10/20 14:34
 */
public class MinStack {

    private final Stack<Integer> dataStack;
    private final Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);

        if (!minStack.empty())
            minStack.push(minStack.peek() < x ? minStack.peek() : x);
        else
            minStack.push(x);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
