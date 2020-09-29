package leetcode;

/**
 * 重新排列单词间的空格
 * https://leetcode-cn.com/problems/rearrange-spaces-between-words/
 *
 * 扫描字符串 计算 单词数, 空格数.
 * 比较细节
 *
 * @author liuxin
 * @time 2020/9/27 21:26
 */
public class ReorderSpaces {

    private static String reorderSpaces(String text) {
        int spaceCount = 0, wordCount = 0;

        boolean lastIsSpace = text.charAt(0) == ' ';
        if (lastIsSpace) {
            spaceCount++;
        } else {
            wordCount++;
        }

        char c;
        for (int i = 1; i < text.length(); i++) {
            c = text.charAt(i);

            if (c == ' ') {
                // 空格
                if (!lastIsSpace) {
                    lastIsSpace = true;
                }
                spaceCount++;

            } else {
                // 字符
                if (lastIsSpace) {
                    lastIsSpace = false;
                    wordCount++;
                }

            }
        }

        System.err.println(spaceCount);
        System.err.println(wordCount);

        if (wordCount == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                c = text.charAt(i);
                if (c != ' ') {
                    sb.append(c);
                }
            }
            for (int i = 0; i < spaceCount; i++) {
                sb.append(' ');
            }

            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        int avgSpaceCnt;
        // 余数
        int remainder = spaceCount % (wordCount - 1);
        if (remainder != 0) {
            avgSpaceCnt = (spaceCount - remainder) / (wordCount - 1);
        } else {
            avgSpaceCnt = spaceCount / (wordCount - 1);
        }

        int idx = 0;
        while (text.charAt(idx) == ' ') {
            idx++;
        }

        while (idx < text.length()) {
            c = text.charAt(idx++);

            if (c != ' ') {
                sb.append(c);
            } else {
                wordCount--;
                if (wordCount != 0) {
                    for (int i = 0; i < avgSpaceCnt; i++) {
                        sb.append(' ');
                    }
                    while (idx < text.length() && text.charAt(idx) == ' ') {
                        idx++;
                    }
                } else {
                    for (; remainder > 0; remainder--) {
                        sb.append(' ');
                    }
                    idx = text.length();
                }
            }
        }

        for (; remainder > 0; remainder--) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.err.println(reorderSpaces(" a   b   c"));
    }

}
