package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * O(1) 时间插入、删除、随机获取随机元素
 *
 * @author liuxin
 * @date 2024/9/29 10:22
 */
public class RandomizedSet {

    private final HashMap<Integer, Integer> map;
    private final Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean exist = map.containsKey(val);
        map.put(val, val);
        return exist;
    }

    public boolean remove(int val) {
        boolean exist = map.containsKey(val);
        map.remove(val);
        return exist;
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(map.values());
        int i = random.nextInt(list.size());
        return list.get(i);
    }


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
    }

}
