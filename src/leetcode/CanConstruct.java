package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/3/14 15:33
 *
 * 赎金信
 * https://leetcode-cn.com/problems/ransom-note/submissions/
 *
 * 思路：使用数组计算每个字母出现的次数
 */
public class CanConstruct {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++){
            arr[magazine.charAt(i) - 97]++;
        }

        for (int i = 0; i < ransomNote.length(); i++){
            if (arr[ransomNote.charAt(i) - 97]-- == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.err.println(canConstruct("aa", "a"));
    }
}
