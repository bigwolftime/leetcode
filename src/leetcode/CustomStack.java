package leetcode;

/**
 * 设计一个支持增量操作的栈
 * https://leetcode-cn.com/problems/design-a-stack-with-increment-operation/
 *
 * 使用数组效率比 list 高
 *
 * @author liuxin
 * @time 2020/10/22 15:22
 */
public class CustomStack {

    private final int[] arr;
    private int curPeek;
    private final int maxSize;

    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
        this.curPeek = -1;
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (curPeek + 1 > maxSize) {
            return;
        }

        curPeek++;
        arr[curPeek] = x;
    }

    public int pop() {
        if (curPeek < 0) {
            return -1;
        }

        int res = arr[curPeek];
        curPeek--;
        return res;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i <= curPeek; i++) {
            arr[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(3);
        customStack.push(1);
        System.err.println(customStack.pop());;
    }

}
