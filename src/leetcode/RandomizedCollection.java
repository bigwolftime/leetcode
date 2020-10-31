package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * O(1) 时间插入, 删除和获取随机元素 - 允许重复
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 *
 * Hash
 *
 * @author liuxin
 * @date 2020/10/31 16:31
 */
public class RandomizedCollection {

    private final HashMap<Integer, Integer> map;
    private int count;
    private final Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        count = 0;

        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        this.count++;

        Integer count = map.get(val);
        if (count == null) {
            map.put(val, 1);
            return true;
        }

        map.put(val, count + 1);
        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Integer count = map.get(val);
        if (count == null) {
            return false;
        }

        this.count--;
        if (count == 1) {
            map.remove(val);
            return true;
        }

        map.put(val, count - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomIdx = random.nextInt(this.count);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            for (int i = 0; i < entry.getValue(); i++) {
                if (randomIdx-- == 0) {
                    return entry.getKey();
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 50;i++) {
            System.err.println(random.nextInt(10));
        }
    }

}
