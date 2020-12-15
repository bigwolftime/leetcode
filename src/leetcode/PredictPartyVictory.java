package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Dota 2 参议院
 * https://leetcode-cn.com/problems/dota2-senate/
 */
public class PredictPartyVictory {

    private static List<Integer> R_INDEX_LIST;
    private static List<Integer> D_INDEX_LIST;

    private static final char CHAR_D = 'D';
    private static final char CHAR_R = 'R';
    private static final char CHAR_X = 'X';

    public static String predictPartyVictory(String senate) {
        R_INDEX_LIST = new ArrayList<>();
        D_INDEX_LIST = new ArrayList<>();
        StringBuilder sb = new StringBuilder(senate);

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == CHAR_R) {
                R_INDEX_LIST.add(i);
            } else {
                D_INDEX_LIST.add(i);
            }
        }

        int res;
        while (sb.length() > 0) {
            res = predict(sb);

            if (res != 0) {
                return res == 1 ? "Dire" : "Radiant";
            }
        }

        return "";
    }

    /**
     * -1: R
     * 1:  D
     * 0:  null
     * @param sb
     * @return
     */
    private static int predict(StringBuilder sb) {
        int cur = 0;

        while (cur < sb.length()) {
            int step = delete(cur, sb);

            cur += step;
        }

        if (R_INDEX_LIST.size() == 0) {
            return 1;
        }
        if (D_INDEX_LIST.size() == 0) {
            return -1;
        }

        return 0;
    }

    private static int delete(int curIdx, StringBuilder sb) {
        char c = sb.charAt(curIdx);
        int tmpIdx;

        if (c == CHAR_R) {
            // delete D

            for (int i = 0; i < D_INDEX_LIST.size(); i++) {
                tmpIdx = D_INDEX_LIST.get(i);

                if (tmpIdx > curIdx) {
                    sb.setCharAt(tmpIdx, CHAR_X);
                    D_INDEX_LIST.remove(i);
                    return 1;
                }
            }

            for (int i = 0; i < D_INDEX_LIST.size(); i++) {
                tmpIdx = D_INDEX_LIST.get(i);

                if (tmpIdx < curIdx) {
                    sb.setCharAt(tmpIdx, CHAR_X);
                    D_INDEX_LIST.remove(i);
                    return 1;
                }
            }
        } else if (c == CHAR_D) {
            // delete R

            for (int i = 0; i < R_INDEX_LIST.size(); i++) {
                tmpIdx = R_INDEX_LIST.get(i);

                if (tmpIdx > curIdx) {
                    sb.setCharAt(tmpIdx, CHAR_X);
                    R_INDEX_LIST.remove(i);
                    return 1;
                }
            }

            for (int i = 0; i < R_INDEX_LIST.size(); i++) {
                tmpIdx = R_INDEX_LIST.get(i);

                if (tmpIdx < curIdx) {
                    sb.setCharAt(tmpIdx, CHAR_X);
                    R_INDEX_LIST.remove(i);
                    return 1;
                }
            }
        }

        return 1;
    }


    public static void main(String[] args) {
        String rdd = predictPartyVictory("DRRDRDRDRDDRDRDR");
        System.err.println(rdd);
    }
}
