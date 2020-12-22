package leetcode;

/**
 * 矩形面积
 * https://leetcode-cn.com/problems/rectangle-area/
 */
public class ComputeArea {

    private static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return -1;
    }

    private static int overlappingArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftPoint = Math.max(A, E), rightPoint = Math.min(C, G);
        int len = Math.abs(rightPoint - leftPoint);

        int topPoint = Math.min(D, H), bottomPoint = Math.max(F, B);
        int h = Math.abs(topPoint - bottomPoint);

        return h * len;
    }

    public static void main(String[] args) {
        // 24 + 27 - 6
    }

}
