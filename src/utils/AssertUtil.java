package utils;

import exception.AssertionException;

/**
 * @author liuxin
 * @date 2024/3/21 16:11
 */
public class AssertUtil {

    public static void eq(int x, int y) {
        if (x == y) {
            return;
        }

        throw new AssertionException(x + "!= " + y);
    }

    public static void eq(boolean b1, boolean b2) {
        if (b1 == b2) {
            return;
        }

        throw new AssertionException(b1 + "!= " + b2);
    }

}
