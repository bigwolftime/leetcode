package offer;

/**
 * 打印从 1 到最大的 n 位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class PrintNumbers {

    private static int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] res = new int[max - 1];

        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        printNumbers(3);
    }

}
