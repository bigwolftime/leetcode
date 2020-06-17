package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/5/5 16:18
 *
 * 反转字符串 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * 使用了双指针
 */
public class ReverseWordsIII {

    public static String reverseWords(String s) {
        int p = 0, q = 0;
        StringBuilder res = new StringBuilder();

        while (q < s.length()){
            while (q < s.length() && s.charAt(q) != ' '){
                q++;
            }

            append(res, s, p, q - 1);

            q++;
            p = q;
        }

        if (res.length() > 0){
            res.delete(res.length() - 1, res.length());
        }

        return res.toString();
    }

    private static void append(StringBuilder res, String s, int start, int end){
        for (; start <= end; end--){
            res.append(s.charAt(end));
        }
        res.append(' ');
    }

    public static void main(String[] args) {
        System.err.println(reverseWords(""));
    }
}
