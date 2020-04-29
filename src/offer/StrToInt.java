package offer;

/**
 * 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * Math.addExact() 的使用
 *
 * like: https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class StrToInt {

    private static int strToInt(String str) {
        boolean isPositiveNum = true;	//是否正数
        char c;

        int startIndex = 0, endIndex = 0;
        while(startIndex < str.length()) {
            if (str.charAt(startIndex) != ' ')
                break;
            startIndex++;
        }	//首先确定第一个数字的索引

        if (startIndex < str.length() && startMatch(str.charAt(startIndex))) {
            c = str.charAt(startIndex);
            if (c == '-') {
                isPositiveNum = false;
                startIndex++;
            }else if (c == '+') {
                startIndex++;
            }
            endIndex = startIndex;

            while(endIndex < str.length()) {
                if (!isDigital(str.charAt(endIndex)))
                    break;

                endIndex++;
            }

            int res = 0;
            if (isPositiveNum) {
                for (int i = endIndex - 1; i >= startIndex; i--) {
                    try {
                        res = Math.addExact(res, (int) ((str.charAt(i) & 0x0f) * Math.pow(10, endIndex - 1 - i)));
                    }catch (ArithmeticException e) {
                        return Integer.MAX_VALUE;
                    }
                }
            }else {
                for (int i = endIndex - 1; i >= startIndex; i--) {
                    try {
                        res = Math.subtractExact(res, (int) ((str.charAt(i) & 0x0f) * Math.pow(10, endIndex -1 - i)));
                    }catch (ArithmeticException e) {
                        return Integer.MIN_VALUE;
                    }
                }
            }

            return res;
        }else
            return 0;
    }

    //去掉空格后的单词开头是否符合要求
    public static boolean startMatch(char c) {
        return isDigital(c) || c == '-' || c == '+';
    }

    public static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }


    public static void main(String[] args) {

    }

}
