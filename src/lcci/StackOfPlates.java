package lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆盘子
 * https://leetcode-cn.com/problems/stack-of-plates-lcci/
 *
 * @author liuxin
 * @time 2020/10/23 16:03
 */
public class StackOfPlates {

    private final int capacity;
    private final List<List<Integer>> lists;

    public StackOfPlates(int cap) {
        this.capacity = cap;
        lists = new ArrayList<>();
    }

    public void push(int val) {
        if (capacity <= 0) {
            // 容量不符合 -> 什么都不做
            return;
        }

        if (lists.isEmpty()) {
            lists.add(new ArrayList<>());
        }

        // 获取最后一个 list
        List<Integer> list = lists.get(lists.size() - 1);

        if (list.size() >= capacity) {
            // 满
            List<Integer> newList = new ArrayList<>();
            newList.add(val);
            lists.add(newList);
        } else {
            list.add(val);
        }
    }

    public int pop() {
        if (lists.isEmpty()) {
            return -1;
        }

        List<Integer> list = lists.get(lists.size() - 1);
        Integer remove = list.remove(list.size() - 1);
        if (list.isEmpty()) {
            lists.remove(lists.size() - 1);
        }

        return remove;
    }

    public int popAt(int index) {
        if (lists.isEmpty() || index < 0 || index >= lists.size()) {
            return -1;
        }

        List<Integer> list = lists.get(index);
        Integer remove = list.remove(list.size() - 1);

        if (list.isEmpty()) {
            lists.remove(index);
        }
        return remove;
    }

    public static void main(String[] args) {

    }

}
