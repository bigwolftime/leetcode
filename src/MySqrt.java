/**
 * x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * 不使用 sqrt() 来计算平方根, 注意处理溢出, 考虑转成 long 计算
 * 1. 二分
 * 2. 使用指数 exp 和对数 ln 代替平方根的计算;
 */
public class MySqrt {

    private static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }

        int left = 1, right = x >> 1, mid;
        long temp = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            temp = (long)mid * mid;

            if (temp < x) {
                left = mid + 1;
            } else if (temp > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        System.err.println(mySqrt(2147483647));
    }

}
