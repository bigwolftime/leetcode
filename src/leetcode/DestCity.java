package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 旅行终点站
 * <a href="https://leetcode.cn/problems/destination-city">...</a>
 *
 * 找到旅行的终点, 即入度 > 0, 出度 = 0
 *
 * @author liuxin
 * @date 2024/10/8 09:44
 */
public class DestCity {

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> outMap = new HashMap<>();

        for (List<String> path : paths) {
            String start = path.get(0);
            String end = path.get(1);

            outMap.put(start, outMap.getOrDefault(start, 0) + 1);
            inMap.put(end, inMap.getOrDefault(end, 0) + 1);
        }

        // inMap 存在但 outMap 不存在, 即入度 > 0, 出度 = 0
        for (String s : inMap.keySet()) {
            if (!outMap.containsKey(s)) {
                return s;
            }
        }

        return "";
    }

    public static void main(String[] args) {

    }

}
