package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/3/13 16:08
 *
 * 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * 思路：利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
 */
public class IsPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        int step = 1;

        while (num > 0){
            num -= step;
            step += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        System.err.println(isPerfectSquare(2147483647));
    }
}
