package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/binary-watch/
 */
public class ReadBinaryWatch {

    private static final List<Integer> HOUR_LIST;
    private static final List<Integer> MINUTE_LIST;

    private static final int LEN;

    static {
        HOUR_LIST = new ArrayList<>();
        HOUR_LIST.add(8);
        HOUR_LIST.add(4);
        HOUR_LIST.add(2);
        HOUR_LIST.add(1);

        MINUTE_LIST = new ArrayList<>();
        MINUTE_LIST.add(32);
        MINUTE_LIST.add(16);
        MINUTE_LIST.add(8);
        MINUTE_LIST.add(4);
        MINUTE_LIST.add(2);
        MINUTE_LIST.add(1);

        LEN = HOUR_LIST.size() + MINUTE_LIST.size();
    }


    private static Set<String> SET = new HashSet<>();


    private static List<String> readBinaryWatch(int turnedOn) {
        for (int i = 0; i < LEN; i++) {
            dfs(0, 0, i, turnedOn);
        }

        return new ArrayList<>(SET);
    }

    private static void dfs(int curHour, int curMinute, int index, int leftCount) {
        if (index >= LEN) {
            return;
        }
        if (curHour >= 24 || curMinute >= 60) {
            return;
        }

        if (leftCount == 0) {
            append(curHour, curMinute);
            return;
        }

        dfs(curHour, curMinute, index + 1, leftCount);

        if (index >= HOUR_LIST.size()) {
            curMinute += MINUTE_LIST.get(index - HOUR_LIST.size());
        } else {
            curHour += HOUR_LIST.get(index);
        }

        dfs(curHour, curMinute, index + 1, leftCount - 1);
    }

    private static void append(int curHour, int curMinute) {
        String str = curHour + ":";
        if (curMinute < 10) {
            str += "0" + curMinute;
        } else {
            str += curMinute;
        }

        SET.add(str);
    }


    public static void main(String[] args) {
        // ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
        // [0:08, 0:04, 8:00, 0:16, 0:02, 1:00, 4:00, 0:32, 2:00]
        System.err.println(readBinaryWatch(1));
    }

}
