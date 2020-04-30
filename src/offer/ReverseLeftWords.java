package offer;

/**
 * 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class ReverseLeftWords {

    private static String reverseLeftWords(String s, int n) {
        StringBuilder reverseStrBuilder = new StringBuilder();
        StringBuilder resBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i < n) {
                reverseStrBuilder.append(s.charAt(i));
            } else {
                resBuilder.append(s.charAt(i));
            }
        }

        return resBuilder.append(reverseStrBuilder).toString();
    }

    public static void main(String[] args) {
        System.err.println(reverseLeftWords("lrloseumgh", 6));
    }

}
