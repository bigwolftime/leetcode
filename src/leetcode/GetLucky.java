package leetcode;

/**
 * 字符串转化后的各位数字之和
 * https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 *
 * @author liuxin
 * @date 2022/12/15 09:47
 */
public class GetLucky {

    private static int getLucky(String s, int k) {
        int sum = 0;
        int val;
        for (int i = 0; i < s.length(); i++) {
            val = (s.charAt(i) - 96);
            while (val != 0) {
                sum += (val % 10);
                val /= 10;
            }
        }

        k--;

        while (k-- > 0) {
            int tempSum = sum;
            sum = 0;

            while (tempSum != 0) {
                sum += tempSum % 10;
                tempSum /= 10;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        int val = getLucky("leetcode", 2);
        System.err.println(val);
    }

}
