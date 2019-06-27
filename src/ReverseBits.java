/**
 * @Author Liuxin
 * @Date 2019/4/26 17:00
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        String binStr = Integer.toBinaryString(n);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <binStr.length(); i++){
            res.append(binStr.charAt(i));
        }

        return 0;
        //return res.toString();
    }

    public static void main(String[] args) {
        reverseBits(-3);
    }
}
