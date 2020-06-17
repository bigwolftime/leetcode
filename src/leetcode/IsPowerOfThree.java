package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/5/5 11:24
 *
 * 3的幂
 * https://leetcode-cn.com/problems/power-of-three/
 */
public class IsPowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n < 1){
            return false;
        }

        int x = 1;
        while (x <= n && x >= 1){
            if (x == n){
                return true;
            }

            x *= 3;
        }
        return false;
    }

    public static void main(String[] args) {
        System.err.println(isPowerOfThree(4));
    }
}
