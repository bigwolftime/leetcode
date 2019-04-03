/**
 * @Author Liuxin
 * @Date 2019/4/3 18:14
 *
 * 七进制数
 * https://leetcode-cn.com/problems/base-7/submissions/
 */
public class ConvertToBase7 {

    public static String convertToBase7(int num) {
        if (num == 0){
            return "0";
        }

        StringBuilder res = new StringBuilder();
        int cur = Math.abs(num);

        while (cur != 0){
            res.insert(0, cur % 7);
            cur /= 7;
        }
        if (num < 0){
            res.insert(0, "-");
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.err.println(convertToBase7(0));
    }
}
