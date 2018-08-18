import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 * @author bwt
 *
 */
public class MyStack {

	Queue<Integer> queue;
	Queue<Integer> tempQueue;
	
	public MyStack() {
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        while(queue.size() > 1) {
        	tempQueue.add(queue.poll());
        }
        
        int res = queue.poll();
        
        while(!tempQueue.isEmpty()) {
        	queue.add(tempQueue.poll());
        }
        
        return res;
    }
    
    public int top() {
    	while(queue.size() > 1) {
        	tempQueue.add(queue.poll());
        }
        
        int res = queue.poll();
        
        while(!tempQueue.isEmpty()) {
        	queue.add(tempQueue.poll());
        }
        queue.add(res);
        
        return res;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		
		System.err.println(myStack.top());
		myStack.pop();
		System.err.println(myStack.top());
	}
}
