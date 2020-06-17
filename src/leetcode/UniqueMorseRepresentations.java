package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Liuxin
 * @Date 2019/5/10 14:56
 *
 * 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 *
 * 将 map 存储改为 数组存储
 */
public class UniqueMorseRepresentations {

    private static String[] morse;

    static {
        morse = new String[]{
            ".-","-...","-.-.","-..",".",
            "..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",
            ".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--","--.."
        };

    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        StringBuilder temp = new StringBuilder();
        for (String str : words){
            for (int i = 0; i < str.length(); i++){
                temp.append(morse[str.charAt(i) - 97]);
            }

            if (!set.contains(temp)){
                set.add(temp.toString());
            }

            temp.delete(0, temp.length());
        }

        return set.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations test = new UniqueMorseRepresentations();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.err.println(test.uniqueMorseRepresentations(words));
    }
}
