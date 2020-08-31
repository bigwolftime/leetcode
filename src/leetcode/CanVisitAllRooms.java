package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 *
 * 邻接表
 *
 * @author liuxin
 * @date 2020/8/31 11:16
 */
public class CanVisitAllRooms {

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 钥匙
        HashSet<Integer> keySet = new HashSet<>();

        // 已遍历的门
        HashSet<Integer> traverseSet = new HashSet<>();

        // 未开启的门
        HashSet<Integer> lockedSet = new HashSet<>();

        int lockedCount = 0;

        while (true) {
            traverse(rooms, keySet, lockedSet, traverseSet);

            if (lockedSet.isEmpty()) {
                return true;
            } else if (lockedSet.size() != lockedCount) {
                lockedCount = lockedSet.size();
            } else {
                return false;
            }
        }
    }

    private static void traverse(List<List<Integer>> rooms, HashSet<Integer> keySet, HashSet<Integer> lockedSet, HashSet<Integer> traverseSet) {
        for (int i = 0; i < rooms.size(); i++) {
            if (!keySet.contains(i) && i != 0) {
                // 非0房间 && 没有钥匙 -> 未开启
                lockedSet.add(i);
                continue;
            }

            if (traverseSet.contains(i)) {
                // 已遍历
                continue;
            }

            keySet.addAll(new HashSet<>(rooms.get(i)));

            // 已遍历
            traverseSet.add(i);
            // 移除
            lockedSet.remove(i);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        rooms.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        rooms.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        rooms.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        rooms.add(list4);

        System.err.println(canVisitAllRooms(rooms));
    }

}
