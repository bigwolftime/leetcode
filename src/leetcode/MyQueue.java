package leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/description/
 * @author bwt
 *
 */
public class MyQueue {

	Stack<Integer> stack;
	Stack<Integer> tmpStack;
	
    public MyQueue() {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(!stack.empty()) {
        	tmpStack.push(stack.pop());
        }
        
        int res = tmpStack.pop();
        while(!tmpStack.empty()) {
        	stack.push(tmpStack.pop());
        }
        
        return res;
    }
    
    public int peek() {
    	while(!stack.empty()) {
        	tmpStack.push(stack.pop());
        }
        
        int res = tmpStack.peek();
        while(!tmpStack.empty()) {
        	stack.push(tmpStack.pop());
        }
        
        return res;
    }
    
    public boolean empty() {
        return stack.empty();
    }
	
	public static void main(String[] args) {
		
	}
}
