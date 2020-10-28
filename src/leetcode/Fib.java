package leetcode;

/**
 * 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author liuxin
 * @time 2020/10/28 20:17
 */
public class Fib {

    private static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        int a = 0, b = 1;
        int fib = a + b;
        for (int i = 2; i <= N; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }

    public static void main(String[] args) {

    }

}
