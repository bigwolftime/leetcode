package leetcode;

/**
 * 压缩字符串
 * https://leetcode-cn.com/problems/string-compression/
 *
 * 需要处理 count == 1 的情况
 *
 * @author liuxin
 * @time 2020/10/23 16:47
 */
public class Compress {

    private static int compress(char[] chars) {
        int idx = 0;
        int length = 0;
        int modifyIdx = 0;

        while (idx < chars.length) {
            length++;
            chars[modifyIdx] = chars[idx];
            int step = -1;

            int count = count(chars, idx);
            if (count <= 9) {
                if (count == 1) {
                    idx++;
                    modifyIdx++;
                    continue;
                }
                length++;
                step = 1;
            } else if (count <= 99) {
                length += 2;
                step = 2;
            } else if (count <= 999) {
                length += 3;
                step = 3;
            } else if (count <= 9999) {
                length += 4;
                step = 4;
            }

            idx += count;

            for (int newIdx = modifyIdx + step; newIdx > modifyIdx; newIdx--) {
                chars[newIdx] = (char) (count % 10 + 48);
                count /= 10;
            }

            modifyIdx = modifyIdx + step + 1;
        }

        return length;
    }

    private static int count(char[] chars, int idx) {
        char c = chars[idx];
        int count = 1;

        for (++idx; idx < chars.length; idx++) {
            if (chars[idx] == c) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.err.println(compress(new char[]{ 'v','r','r','r','r','r','r','r','r','r' }));
    }

}
