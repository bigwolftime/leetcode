package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/3/26 15:35
 *
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/submissions/
 *
 * 思路：因为只包含小写字符，所以使用长度 26 个 int 的数组，来记录，
 * 来记录每个字符出现的次数
 */
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 97]++;
        }

        int index = 0;
        for (int i = 0; i < t.length(); i++){
            index = t.charAt(i) - 97;
            if (arr[index]-- == 0){
                return false;
            }
        }

        //例如：s = "abc", t = "abcd"
        //执行到此行应该做长度判断
        if (t.length() < s.length()){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.err.println(isAnagram("rat", "artss"));
    }
}
