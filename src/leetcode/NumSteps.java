package leetcode;

/**
 * 将二进制表示减到 1 的步骤数
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 *
 * 1 <= s.length <= 500, 考虑溢出，不转整数
 *
 *偶数除以2 即整体右移1位
 */
public class NumSteps {

    private static int numSteps(String s) {
        int step = 0;
        int len = s.length();
        int[] arr = new int[len + 1];

        for (int i = 0; i < len; i++) {
            arr[i + 1] = s.charAt(i) - 48;
        }

        while (!checkIsOne(arr)) {
            if (arr[len] == 1) {
                // 奇数 -> 加1
                addOne(arr);
            } else {
                // 偶数 -> 除以2 即整体右移1位
                moveRight(arr);
            }

            step++;
        }

        return step;
    }

    private static void addOne(int[] arr) {
        boolean flag = arr[arr.length - 1] == 1;
        if (flag) {
            arr[arr.length - 1] = 0;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            int cur = arr[i];

            if (cur == 0) {
                // 当前为 0

                if (flag) {
                    // 有进位
                    arr[i] = 1;
                }

                // 进位被消 可结束
                break;
            } else {
                // 当前为 1

                if (flag) {
                    // 有进位
                    arr[i] = 0;
                    flag = true;
                } else {
                    // 无进位 可结束
                    break;
                }

            }
        }
    }

    private static void moveRight(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = 0;
    }

    private static boolean checkIsOne(int[] arr) {
        if (arr[arr.length - 1] == 0) {
            return false;
        }

        int cnt = 0;
        for (int val : arr) {
            if (val == 1 && ++cnt > 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.err.println(numSteps("1"));;
    }

}
