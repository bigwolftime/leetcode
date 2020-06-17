package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/5/5 14:24
 *
 * 坏了的计算器
 * https://leetcode-cn.com/problems/broken-calculator/
 *
 * 使用逆向的思路，想要降低次数，就要尽量执行 /2 操作
 */
public class BrokenCalc {

    public static int brokenCalc(int X, int Y) {
        if (X > Y) {
            return X - Y;
        }

        int count = 0;
        while (X != Y) {
            if (Y > X && Y % 2 == 0) {
                Y >>= 1;
            }else if (Y == X){
                return count;
            }else {
                Y++;
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.err.println(brokenCalc(5, 8));
    }
}
