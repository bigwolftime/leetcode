package leetcode;

/**
 * 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @author liuxin
 * @date 2020/6/7 10:26
 */
public class CountAndSay {

    private static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");

        StringBuilder tempBuilder;
        int count;
        int cur = 0;
        char c;

        while (--n > 0) {
            tempBuilder = new StringBuilder();

            do {
                count = 1;
                c = sb.charAt(cur);

                while (cur + 1 < sb.length() && sb.charAt(cur + 1) == c) {
                    count++;
                    cur++;
                }

                tempBuilder.append(count).append(c & 0xf);

                cur++;
            } while (cur != sb.length());

            sb = tempBuilder;
            cur = 0;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.err.println(countAndSay(1));
    }

}
