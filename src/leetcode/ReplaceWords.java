package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词替换
 * https://leetcode.cn/problems/replace-words/
 *
 * @author liuxin
 * @date 2022/7/7 9:09 PM
 */
public class ReplaceWords {

    private static final char SPACE_CHAR = ' ';


    private static String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder resBuilder = new StringBuilder();
        Set<String> dictionarySet = new HashSet<>(dictionary);


        int cur = 0;
        while (cur < sentence.length()) {

            StringBuilder curBuilder = new StringBuilder();
            char c;
            while (cur < sentence.length() && (c = sentence.charAt(cur)) != SPACE_CHAR) {
                curBuilder.append(c);

                if (dictionarySet.contains(curBuilder.toString())) {
                    cur = findNextSpace(cur, sentence);
                } else {
                    cur++;
                }
            }

            resBuilder.append(curBuilder).append(SPACE_CHAR);
            cur++;
        }


        return resBuilder.length() > 0 ? resBuilder.substring(0, resBuilder.length() - 1) : resBuilder.toString();
    }

    /**
     * 寻找下一个单词首字母
     * @param cur
     * @param sentence
     * @return
     */
    private static int findNextSpace(int cur, String sentence) {
        while (cur < sentence.length() && sentence.charAt(cur) != SPACE_CHAR) {
            cur++;
        }

        return cur;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String res = replaceWords(list, "aadsfasf absbs bbab cadsfafs");
        System.err.println(res);

    }
}
