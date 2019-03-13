/**
 * @Author Liuxin
 * @Date 2019/3/13 18:17
 *
 * 2 的幂
 * https://leetcode-cn.com/problems/power-of-two/comments/
 *
 * 思路：HashMap 源代码中的 tableSizeFor() 方法：传入 n，返回大于等于 n 的 2 的幂次；
 * 另一种思路：只要是 2 的倍数，二进制最高位是 1，其余是 0，即 (n & (n - 1)) == 0
 */
public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n < 1){
            return false;
        }

        return n == tableSizeFor(n);
    }

    private static int tableSizeFor(int cap){
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public static void main(String[] args) {
        System.err.println(isPowerOfTwo(2));
        //isPowerOfTwo(0);
    }
}
