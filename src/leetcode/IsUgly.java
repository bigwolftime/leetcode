package leetcode;

/**
 * 丑数
 * https://leetcode-cn.com/problems/ugly-number/
 *
 * @author liuxin
 * @time 2020/10/23 16:23
 */
public class IsUgly {

    private static boolean isUgly(int num) {
        boolean flag;

        while (num > 1) {
            flag = false;

            if (num % 2 == 0) {
                flag = true;
                num /= 2;
            }

            if (num % 3 == 0) {
                flag = true;
                num /= 3;
            }

            if (num % 5 == 0) {
                flag = true;
                num /= 5;
            }

            if (!flag) {
                break;
            }
        }

        return num == 1;
    }

    public static void main(String[] args) {

    }

}
