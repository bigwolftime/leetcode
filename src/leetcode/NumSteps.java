package leetcode;

/**
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 */
public class NumSteps {

    private static int numSteps(String s) {
        // 考虑溢出，不转整数
        int step = 0;
        int len = s.length();
        int[] arr = new int[len + 1];

        for (int i = 0; i < len; i++) {
            arr[i + 1] = s.charAt(i) - 48;
        }

        while (!onlyOne(arr)) {
            if (arr[len - 1] == 1) {
                // 奇数 -> 加1
                addOne(arr);
            } else {
                // 偶数 -> 除以2 即整体右移1位
                moveRight(arr);
            }
        }

        return step;
    }

    private static void addOne(int[] arr) {
        boolean flag = false;
        for (int i = arr.length - 1; i >= 0; i--) {

        }
    }

    private static void moveRight(int[] arr) {

    }

    private static boolean onlyOne(int[] arr) {
        int cnt = 0;
        for (int val : arr) {
            if (val == 1 && ++cnt > 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        numSteps("1001");
    }

}
