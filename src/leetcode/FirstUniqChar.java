package leetcode;

/**
 * @Author Liuxin
 * @Date 2019/3/14 14:53
 *
 * 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/submissions/
 *
 * 思路：最笨的方法：使用 map 计算每个字符的次数，然后再遍历字符串
 */
public class FirstUniqChar {

    /*public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char c;

        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);

            if (!map.containsKey(c)){
                map.put(c, 1);
                continue;
            }
            map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }*/

    //只包含小写字母
    public static int firstUniqChar(String s) {
        int[] res = new int[26];

        for (int i = 0; i < s.length(); i++){
            res[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < s.length(); i++){
            if (res[s.charAt(i) - 97] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.err.println(firstUniqChar("leetcode"));
    }
}
