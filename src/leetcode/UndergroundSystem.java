package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/design-underground-system/
 * 不知为啥错了 case progress：52/56
 *
 * @author liuxin
 * @date 2021/9/18 4:05 下午
 */
public class UndergroundSystem {

    /**
     * key：startStationName
     * val：Map
     *      key: id
     *      val: startTime
     */
    private final Map<String, Map<Integer, Integer>> startMap;

    /**
     * key: endStationName
     * val: Map
     *      key: id
     *      val: endTime
     */
    private final Map<String, Map<Integer, Integer>> endMap;

    public UndergroundSystem() {
        startMap = new HashMap<>(8);
        endMap = new HashMap<>(8);
    }

    public void checkIn(int id, String stationName, int t) {
        Map<Integer, Integer> map = startMap.get(stationName);

        if (map == null) {
            map = new HashMap<>();
            startMap.put(stationName, map);
        }
        map.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        Map<Integer, Integer> map = endMap.get(stationName);

        if (map == null) {
            map = new HashMap<>();
            endMap.put(stationName, map);
        }

        map.put(id, t);
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<Integer, Integer> startTimeMap = startMap.get(startStation);
        Map<Integer, Integer> endTimeMap = endMap.get(endStation);

        int totalCount = 0;
        int totalTime = 0;
        for (Map.Entry<Integer, Integer> entry : startTimeMap.entrySet()) {
            Integer id = entry.getKey();

            Integer endTime = endTimeMap.get(id);
            if (endTime == null) {
                // 未到此站
                continue;
            }

            Integer startTime = entry.getValue();

            totalCount++;
            totalTime += (endTime - startTime);
        }

        return (double) totalTime / totalCount;
    }

}
