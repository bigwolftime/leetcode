package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断句子是否为全字母句
 * https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 *
 * @author liuxin
 * @date 2022/12/13 15:38
 */
public class CheckIfPangram {


    private static boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        Set<Character> set = preSet();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            set.remove(c);

            if (set.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    private static Set<Character> preSet() {
        Set<Character> set = new HashSet<>();
        for (int i = 97; i < 97 + 26; i++) {
            set.add((char) i);
        }

        return set;
    }




    public static void main(String[] args) {

    }

}
