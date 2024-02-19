package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Bigram 分词<br/>
 * <a href="https://leetcode.cn/problems/occurrences-after-bigram">...</a>
 *
 * @author liuxin
 * @date 2024/2/19 17:13
 */
public class FindOcurrences {

    private static String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> list = new ArrayList<>();

        int i = 0;
        while (i < split.length) {
            if (isMatch(first, second, split, i)) {
                list.add(split[i + 2]);
            }
            i++;
        }

        return list.toArray(new String[0]);
    }

    private static boolean isMatch(String first, String second, String[] split, int i) {
        return i + 2 < split.length && first.equals(split[i]) && second.equals(split[i+1]);
    }


    public static void main(String[] args) {
        String s = "alice is a good girl she is a good student";

        findOcurrences(s, "a", "good");
    }

}
