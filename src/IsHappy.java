import java.util.HashSet;

/**
 * @Author Liuxin
 * @Date 2019/3/26 14:35
 *
 * 快乐数
 * https://leetcode-cn.com/problems/happy-number/comments/
 * 思路：如果一个数不是快乐数，那么会进入一个循环，就是 set 中的值。
 */
public class IsHappy {

    public static boolean isHappy(int n) {
        HashSet<Integer> set = createSet();
        int cur, temp = 0;

        while (!set.contains(n)) {
            cur = n;
            while (cur != 0){
                temp += Math.pow(cur % 10, 2);
                cur /= 10;
            }

            if (temp != 1){
                n = temp;
                temp = 0;
                continue;
            }
            return true;
        }

        return false;
    }

    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(16);
        set.add(37);
        set.add(58);
        set.add(89);
        set.add(145);
        set.add(42);
        set.add(20);
        return set;
    }

    public static void main(String[] args) {
        System.err.println(isHappy(20));
    }
}
