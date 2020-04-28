/**
 * 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Divide {

    private static int divide(int dividend, int divisor) {
        return recursive(dividend, divisor, 1);
    }

    private static int recursive(int devidend, int devisor, int base) {
        return 1;
    }

    public static void main(String[] args) {
        divide(100, 3);
    }

}
