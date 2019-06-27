/**
 * @author Liuxin
 * @since 2019/6/27 18:33
 *
 * 数字转换为十六进制数
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 */
public class ToHex {

    public static String toHex(int num) {
        if (num < 0){

        }

        int tmp;
        StringBuilder res = new StringBuilder();
        while (num != 0){
            tmp = num % 16;
            res.append(tmp >= 10 ? (char)(tmp + 87) : tmp);
            num /= 10;
        }

        System.err.println(res);

        return "";
    }

    public static void main(String[] args) {
        toHex(10);
    }
}
