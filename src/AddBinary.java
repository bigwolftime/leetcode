import java.util.ArrayList;
import java.util.List;

/**
 *  二进制求和
 *  https://leetcode-cn.com/problems/add-binary/
 * @author bwt
 *
 *  代码繁琐，不推荐
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        //进位标记，默认不需要进位
        boolean flag = false;
        StringBuilder res = new StringBuilder();
        int temp = 0;

        int p = a.length() - 1, q = b.length() - 1;
        while (p >= 0 && q >= 0){
            temp = (a.charAt(p) & 0x0f) + (b.charAt(q) & 0x0f);

            if (temp == 0 || temp == 1){
                //有进位
                if (flag){
                    if (temp == 0){
                        res.append(1);
                        flag = false;
                    }else {
                        res.append(0);
                        flag = true;
                    }
                }else {
                    res.append(temp);
                }
            }else {
                //有进位
                if (flag){
                    res.append(1);
                }else {
                    res.append(0);
                }
                flag = true;
            }

            p--;
            q--;
        }

        //考虑位数不一致的情况
        if (p != -1){
            res = leftLengthCalc(res, a.substring(0, p + 1), flag);
        }else if (q != -1){
            res = leftLengthCalc(res, b.substring(0, q + 1), flag);
        }else {
            if (flag){
                res.append(1);
            }
        }

        return res.reverse().toString();
    }

    public static StringBuilder leftLengthCalc(StringBuilder res, String str, boolean flag){
        int len = str.length() - 1;
        int temp = 0;

        while(len >= 0){
            temp = str.charAt(len) & 0x0f;

            if (temp == 0){
                if (flag){
                    res.append(1);
                    flag = false;
                }else {
                    res.append(0);
                }
            }else if (temp == 1){
                if (flag){
                    res.append(0);
                }else {
                    res.append(1);
                }
            }

            len--;
        }

        //考虑最后的进位
        if (flag){
            res.append(1);
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));
        //System.out.println("11".substring(0, 1));
    }
}
