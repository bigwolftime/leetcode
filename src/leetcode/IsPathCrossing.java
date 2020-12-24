package leetcode;

import java.util.HashSet;

/**
 * 判断路径是否相交
 * https://leetcode-cn.com/problems/path-crossing/
 */
public class IsPathCrossing {

    private static final String UNDER_LINE = "_";


    private static boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<String> set = new HashSet<>();
        set.add(x + UNDER_LINE + y);

        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    break;
            }

            if (!set.add(x + UNDER_LINE + y)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        isPathCrossing("NESWW");
    }

}
