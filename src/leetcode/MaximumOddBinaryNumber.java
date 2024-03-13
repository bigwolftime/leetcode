package leetcode;

/**
 * 最大二进制奇数<br/>
 * <a href="https://leetcode.cn/problems/maximum-odd-binary-number">...</a>
 *
 * @author liuxin
 * @date 2024/3/13 16:04
 */
public class MaximumOddBinaryNumber {

    private static String maximumOddBinaryNumber(String s) {
        int oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCnt++;
            }
        }

        int zeroCnt = s.length() - oneCnt;

        StringBuilder sb = new StringBuilder();
        while (--oneCnt > 0) {
            sb.append(1);
        }

        while (zeroCnt-- > 0) {
            sb.append(0);
        }
        sb.append(1);

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = maximumOddBinaryNumber("01001");
        System.err.println(s);
    }

}
