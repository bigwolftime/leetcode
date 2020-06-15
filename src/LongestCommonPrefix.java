/**
 * @Author Liuxin
 * @Date 2019/3/26 16:17
 *
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/submissions/
 *
 * 思路：一种纵向扫描，从下标 0 开始，遍历每个字符串，直到遇到不相同的字符串
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();

        if (strs.length == 0 || strs[0].isEmpty()){
            return res.toString();
        }

        int index = 0;
        res.append(strs[0].charAt(index));
        while (true){
            for (int i = 1; i < strs.length; i++){
                if (!strs[i].startsWith(res.toString())){
                    return res.substring(0, res.length() - 1);
                }
            }
            if (++index < strs[0].length()){
                res.append(strs[0].charAt(index));
                continue;
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        System.err.println(longestCommonPrefix(strs));
    }
}
