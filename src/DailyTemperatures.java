/**
 * @Author Liuxin
 * @Date 2019/4/3 18:53
 *
 * 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/comments/
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {
        int count = T.length;
        int cur, wait = 0;

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

        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{55,38,53,81,61,93,97,32,43,78};
        int[] res = dailyTemperatures(T);
        for (int i : res){
            System.err.println(i);
        }
    }
}
