package leetcode;

/**
 * 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Divide {

    /**
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     */
    private static int divide(int dividend, int divisor) {
        boolean dividendFlag = true;
        if (dividend < 0) {
            dividendFlag = false;
            dividend = -dividend;
        }
        boolean divisorFlag = true;
        if (divisor < 0) {
            divisorFlag = false;
            divisor = -divisor;
        }

        // 1. 确定大致范围
        int res = 1;
        int product = divisor;
        while (product <= dividend) {
            if (product == dividend) {
                return (dividendFlag ^ divisorFlag) ? -res : res;
            }

            res <<= 1;
            product = res * divisor;
        }

        // 2. 二分查找
        int left = res >> 1, right = res;
        int mid;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            product = mid * divisor;

            if (product < dividend) {
                left = mid;
            } else if (product > dividend) {
                right = mid;
            } else {
                left = mid;
                break;
            }
        }

        return (dividendFlag ^ divisorFlag) ? -left : left;
    }

    public static void main(String[] args) {
        System.err.println(divide(-2147483648, -1));;
    }

}
