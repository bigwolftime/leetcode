package leetcode;

/**
 * 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * @author liuxin
 * @time 2020/5/23 9:56
 */
public class MinWindow {

    private static String minWindow(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 65] = 1;
        }

        int p = 0, q = p;
        StringBuilder sb = new StringBuilder();

        while (q < s.length()) {
            q = p;

            for (int i = p; i < s.length(); i++) {
                if (arr[s.charAt(i) - 65] == 1) {
                    p = i;
                    break;
                }
            }

            

        }

        return "";
    }

    public static void main(String[] args) {
        System.err.println('A' - 65);
    }

}
