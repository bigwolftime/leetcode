/**
 * 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/
 * 解析：
 * 谁先面临 N = 2 的情况即成功
 * A 先手
 * 若 N 为奇数，一轮操作后必为偶数，B 一直选择 1。A false
 * 若 N 为偶数，A 只需一直选择 1。A true
 * 即判断奇偶数。
 *
 * @author Liuxin
 * @since 2019/8/16 14:27
 */
public class DivisorGame {

    public static boolean divisorGame(int N) {
        if (N % 2 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        divisorGame(10);
    }
}
