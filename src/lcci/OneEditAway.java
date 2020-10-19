package lcci;

/**
 * 一次编辑
 * https://leetcode-cn.com/problems/one-away-lcci/
 *
 * @author liuxin
 * @time 2020/10/19 11:38
 */
public class OneEditAway {

    private static boolean oneEditAway(String first, String second) {
        int firstLen = first.length(), secondLen = second.length();
        if (Math.abs(firstLen - secondLen) >= 2) {
            // 长度差距 >= 2
            return false;
        }

        if (first.length() == second.length()) {
            // 长度相同, 替换
            boolean chance = true;

            for (int i = 0; i < firstLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!chance) {
                        return false;
                    } else {
                        chance = false;
                    }
                }
            }

        } else {
            // 长度不同 -> 插入 / 删除

            int i = 0, j = 0;
            boolean chance = true;
            while (i < firstLen && j < secondLen) {
                if (first.charAt(i) != second.charAt(j)) {
                    if (!chance) {
                        return false;
                    } else {
                        chance = false;
                        if (firstLen > secondLen) {
                            i++;
                        } else {
                            j++;
                        }
                    }
                } else {
                    i++;
                    j++;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.err.println(oneEditAway("pale", "ple"));
    }

}
