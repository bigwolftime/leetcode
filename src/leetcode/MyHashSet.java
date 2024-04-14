package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计哈希集合<br/>
 * <a href="https://leetcode.cn/problems/design-hashset">...</a>
 *
 * @author liuxin
 * @date 2024/4/14 14:52
 */
public class MyHashSet {

    private static final int SIZE = 1024;

    private List<Integer>[] arr;

    public MyHashSet() {
        arr = new List[SIZE];
    }

    public void add(int key) {
        int mod = key % SIZE;
        List<Integer> integers = arr[mod];

        if (integers == null) {
            integers = new ArrayList<>();
            arr[mod] = integers;
        }

        if (integers.contains(key)) {
            // repeat
            return;
        }

        arr[mod].add(key);
    }

    public void remove(int key) {
        int mod = key % SIZE;
        List<Integer> integers = arr[mod];

        if (integers == null || integers.isEmpty()) {
            return;
        }

        integers.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int mod = key % SIZE;
        List<Integer> integers = arr[mod];

        if (integers == null || integers.isEmpty()) {
            return false;
        }

        return integers.contains(key);
    }

}
