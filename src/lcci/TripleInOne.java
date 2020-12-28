package lcci;

/**
 * 三合一
 * https://leetcode-cn.com/problems/three-in-one-lcci/
 */
public class TripleInOne {

    /**
     * data
     */
    private final int[] array;

    /**
     * capacity of every stack
     */
    private final int capacity;

    /**
     * occupy of each stack
     */
    int[] sizeArr = new int[3];


    public TripleInOne(int stackSize) {
        this.array = new int[stackSize * 3];
        this.capacity = stackSize;
    }

    public void push(int stackNum, int value) {
        int curSize = sizeArr[stackNum];

        if (curSize >= capacity) {
            // stack full
            return;
        }

        // write value
        array[stackNum * capacity + curSize] = value;

        // occupy increment
        sizeArr[stackNum]++;
    }

    public int pop(int stackNum) {
        int curSize = sizeArr[stackNum];

        if (curSize <= 0) {
            // stack empty
            return -1;
        }

        int val = array[stackNum * capacity + curSize - 1];
        // occupy decrement
        sizeArr[stackNum]--;

        return val;
    }

    public int peek(int stackNum) {
        int curSize = sizeArr[stackNum];

        if (curSize <= 0) {
            // stack empty
            return -1;
        }

        return array[stackNum * capacity + curSize - 1];
    }

    public boolean isEmpty(int stackNum) {
        return sizeArr[stackNum] <= 0;
    }


    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);

        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.isEmpty(0);
    }

}
