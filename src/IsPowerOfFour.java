/**
 * @Author Liuxin
 * @Date 2019/5/5 10:47
 *
 * 4 的幂
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class IsPowerOfFour {

    public static boolean isPowerOfFour(int num) {
        //若是 4 的幂，则一定是 2 的幂
        boolean isPowerOfTwo = num >= 1 && (num & (num - 1)) == 0;
        //整型：4byte 即 32bit    并满足奇数位为 1
        return isPowerOfTwo && (0x55555555 & num) != 0;
    }

    public static void main(String[] args) {
        System.err.println(isPowerOfFour(4));
    }
}
