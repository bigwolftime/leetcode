package leetcode;

/**
 * 有效的山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 *
 * 双指针 左右两侧都是上山, 看最后的山顶指针是否相等
 *
 * @author liuxin
 * @time 2020/11/3 9:43
 */
public class ValidMountainArray {

    private static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int p = 0, q = A.length - 1;

        for (int cur = 1; cur < A.length; cur++) {
            if (A[cur] < A[cur - 1]) {
                p = cur - 1;
                break;
            } else if (A[cur] == A[cur - 1]) {
                return false;
            }
        }

        for (int cur = A.length - 1; cur > 0; cur--) {
            if (A[cur] > A[cur - 1]) {
                q = cur;
                break;
            } else if (A[cur] == A[cur - 1]) {
                return false;
            }
        }

        return p == q;
    }

    public static void main(String[] args) {

    }

}
