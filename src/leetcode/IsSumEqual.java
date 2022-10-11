package leetcode;

/**
 * 检查某单词是否等于两单词之和
 * https://leetcode.cn/problems/check-if-word-equals-summation-of-two-words/
 *
 * @author liuxin
 * @date 2022/10/9 19:37
 */
public class IsSumEqual {

    private static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int param1 = convertToNum(firstWord);
        int param2 = convertToNum(secondWord);
        int target = convertToNum(targetWord);
        return param1 + param2 == target;
    }

    private static int convertToNum(String word) {
        int sum = 0;
        int pow = 0;

        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            int num = c - 97;
            sum += (num * Math.pow(10, pow));
            pow++;
        }

        return sum;
    }

    public static void main(String[] args) {
        boolean sumEqual = isSumEqual("acb", "cba", "cdb");
        System.err.println(sumEqual);
    }

}
