package leetcode;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * 字母板上的路径
 * https://leetcode-cn.com/problems/alphabet-board-path/
 *
 * 计算路径时需考虑范围有效性
 */
public class AlphabetBoardPath {

    private static HashMap<Character, Pair<Integer, Integer>> MAP;

    private static String alphabetBoardPath(String target) {
        initMap();

        Pair<Integer, Integer> originalCoordinate = new Pair<>(0, 0);
        StringBuilder resBuilder = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);

            Pair<Integer, Integer> targetCoordinate = MAP.get(c);
            String path = calcPathByCoordinate(originalCoordinate.getKey(), originalCoordinate.getValue(), targetCoordinate.getKey(), targetCoordinate.getValue());
            resBuilder.append(path).append("!");

            originalCoordinate = targetCoordinate;
        }

        return resBuilder.toString();
    }

    private static void initMap() {
        if (MAP != null) {
            return;
        }

        MAP = new HashMap<>();

        String s = "abcdefghijklmnopqrstuvwxyz";

        int rowIdx = 0;
        for (int i = 0; i < s.length();) {

            for (int j = 0; j < 5 && i < s.length(); j++) {
                MAP.put(s.charAt(i), new Pair<>(rowIdx, j));
                i++;
            }
            rowIdx++;
        }
    }

    /**
     * 根据坐标计算路径
     */
    private static String calcPathByCoordinate(int curX, int curY, int targetX, int targetY) {
        StringBuilder sb = new StringBuilder();

        int rowDiff = curX - targetX;
        int colDiff = curY - targetY;

        while (rowDiff != 0 || colDiff != 0) {
            while (rowDiff > 0 && nextStepCheck(curX - 1, curY)) {
                rowDiff--;
                curX--;
                sb.append("U");
            }
            while (rowDiff < 0 && nextStepCheck(curX + 1, curY)) {
                rowDiff++;
                curX++;
                sb.append("D");
            }

            while (colDiff > 0 && nextStepCheck(curX, curY - 1)) {
                colDiff--;
                curY--;
                sb.append("L");
            }
            while (colDiff < 0 && nextStepCheck(curX, curY + 1)) {
                colDiff++;
                curY++;
                sb.append("R");
            }
        }

        return sb.toString();
    }

    private static boolean nextStepCheck(int x, int y) {
        if (x < 5) {
            return true;
        }
        return y == 0;
    }

    public static void main(String[] args) {
        System.err.println(alphabetBoardPath("leet"));;
    }

}
