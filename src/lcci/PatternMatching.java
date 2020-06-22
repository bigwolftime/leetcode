package lcci;

/**
 * 模式匹配
 * https://leetcode-cn.com/problems/pattern-matching-lcci/
 *
 * 转化为解 二元一次方程
 *
 * @author liuxin
 * @time 2020/6/22 10:16
 */
public class PatternMatching {

    private static boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0 && value.length() == 0) {
            return true;
        }
        if (pattern.length() == 0) {
            return false;
        }

        int aCount = 0, bCount = 0;

        // 计算 a,b 出现的次数
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        if (aCount == 0 && bCount == 0) {
            return true;
        }

        int valueLen = value.length();
        if (aCount == 0) {
            return fillStringAndMatch(pattern, value, 0, valueLen / bCount);
        } else if (bCount == 0) {
            return fillStringAndMatch(pattern, value, valueLen / aCount, 0);
        }

        // aCount * xLen + bCount * yLen = value.length
        int xLen = 0, yLen;
        int left;
        while (xLen < value.length()) {
            left = valueLen - (aCount * xLen);

            if (left % bCount == 0) {
                // 整数计算
                yLen = left / bCount;

                // pattern matching
                if (fillStringAndMatch(pattern, value, xLen, yLen)) {
                    return true;
                }
            }

            xLen++;
        }

        return false;
    }

    /**
     * 根据 xLen, yLen 填充字符串, 然后匹配
     * @param pattern
     * @param value
     * @param xLen
     * @param yLen
     * @return
     */
    private static boolean fillStringAndMatch(String pattern, String value, int xLen, int yLen) {
        StringBuilder x = new StringBuilder(), y = new StringBuilder();

        fillString(pattern, value, x, y, xLen, yLen, true);

        // 开始匹配
        boolean match = match(pattern, value, x.toString(), y.toString());
        if (match) {
            return true;
        }

        x = new StringBuilder();
        y = new StringBuilder();
        fillString(pattern, value, x, y, xLen, yLen, false);

        return match(pattern, value, x.toString(), y.toString());
    }

    private static void fillString(String pattern, String value, StringBuilder x, StringBuilder y, int xLen, int yLen, boolean flag) {
        boolean xFill = false, yFill = false;
        int index;

        if (flag) {
            index = 0;
            for (int i = 0; i < pattern.length(); i++) {
                // 根据 xLen, yLen 填充字符串
                if (pattern.charAt(i) == 'a') {
                    while (xLen > 0) {
                        // 补充 x 字符串
                        x.append(value.charAt(index++));
                        xLen--;
                    }
                    xFill = true;
                } else {
                    while (yLen > 0) {
                        // 补充 y 字符串
                        y.append(value.charAt(index++));
                        yLen--;
                    }
                    yFill = true;
                }

                if (xFill && yFill) {
                    // 填充完毕
                    break;
                }
            }
        } else {
            index = value.length() - 1;
            for (int i = pattern.length() - 1; i >= 0; i--) {
                // 根据 xLen, yLen 填充字符串
                if (pattern.charAt(i) == 'a') {
                    while (xLen > 0) {
                        // 补充 x 字符串
                        x.append(value.charAt(index--));
                        xLen--;
                    }
                    xFill = true;
                } else {
                    while (yLen > 0) {
                        // 补充 y 字符串
                        y.append(value.charAt(index--));
                        yLen--;
                    }
                    yFill = true;
                }

                if (xFill && yFill) {
                    // 填充完毕
                    break;
                }
            }
        }
    }

    /**
     * 已得到 x,y 开始匹配
     * @param pattern
     * @param x
     * @param y
     * @return
     */
    private static boolean match(String pattern, String value, String x, String y) {
        StringBuilder patternBuilder = new StringBuilder();

        for (int i = 0; i < pattern.length(); i++) {
            patternBuilder.append(pattern.charAt(i) == 'a' ? x : y);
        }

        if (patternBuilder.length() != value.length()) {
            return false;
        }

        int index = 0;
        while (index < patternBuilder.length()) {
            if (patternBuilder.charAt(index) != value.charAt(index)) {
                return false;
            }
            index++;
        }

        return true;
    }

    public static void main(String[] args) {
        // "bbbbbbbbbbbbbbabbbbb"
        // "ppppppppppppppjsftcleifftfthiehjiheyqkhjfkyfckbtwbelfcgihlrfkrwireflijkjyppppg"
        System.err.println(patternMatching(
                "bbbbbbbbbbbbbbabbbbb",
                 "ppppppppppppppjsftcleifftfthiehjiheyqkhjfkyfckbtwbelfcgihlrfkrwireflijkjyppppp"));
    }

}
