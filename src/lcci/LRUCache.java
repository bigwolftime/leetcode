package lcci;

import java.util.LinkedHashMap;

/**
 * LRU 缓存
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 *
 * 使用 LinkedHashMap 既可以保证 O(1) 的读取，也可以存储数据
 *
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> map;

    private final int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer val = map.get(key);
        if (val == null) {
            return -1;
        }

        map.remove(key);
        map.put(key, val);

        return val;
    }

    public void put(int key, int value) {
        map.remove(key);
        map.put(key, value);

        if (map.size() > capacity) {
            map.remove(map.keySet().iterator().next());
        }
    }


    public static void main(String[] args) {

    }

}
