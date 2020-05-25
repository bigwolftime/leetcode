import java.util.LinkedHashMap;

/**
 * @Author Liuxin
 * @Date 2019/3/29 11:03
 *
 * LRU 缓存机制
 * https://leetcode-cn.com/problems/lru-cache
 */
public class LRUCache {

    LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public void put(Integer key, Integer value) {
        map.remove(key);

        if (map.size() >= capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }

    public int get(Integer key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.err.println(cache.get(1));       // 返回  1
    }
}
