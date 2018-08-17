import java.util.Stack;

/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/description/
 * @author bwt
 *
 */
public class MinStack {

	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	
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
    
    public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		
		System.err.println(obj.top());
		System.err.println(obj.getMin());
	}
}
