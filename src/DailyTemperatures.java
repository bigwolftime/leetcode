import java.util.Stack;

/**
 * @Author Liuxin
 * @Date 2019/4/3 18:53
 *
 * 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/comments/
 *
 * 单调栈
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        int cur, idx;

        for (int i = 0; i < T.length; i++) {
            cur = T[i];

            while (!stack.isEmpty() && cur > T[stack.peek()]) {
                idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        return res;

        // 暴力 O(n * n)
        /*int count = T.length;
        int cur, wait;

        int[] res = new int[count];
        for (int i = 0; i < count; i++){
            cur = T[i];
            wait = 0;

            for (int j = i + 1; j < count; j++){
                wait++;

                if (T[j] > cur){
                    res[i] = wait;
                    break;
                }
            }
        }

        return res;*/
    }

    public static void main(String[] args) {
        int[] T = new int[]{73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(T);
        for (int i : res){
            System.err.println(i);
        }
    }
}
