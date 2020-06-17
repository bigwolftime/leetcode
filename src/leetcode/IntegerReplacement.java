package leetcode;

/**
 * @author Liuxin
 * @since 2019/6/27 20:31
 *
 * 整数替换
 * https://leetcode-cn.com/problems/integer-replacement/
 */
public class IntegerReplacement {

    public static int integerReplacement(int n) {
        while (n != 1){
            if ((n & (0x1)) == 0) {
                n >>= 1;
            }else {

            }
        }

        return 1;
    }

    public static void main(String[] args) {
        integerReplacement(6);
    }
}
