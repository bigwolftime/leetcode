package lcci;

import java.util.HashMap;

/**
 * 单词频率
 * https://leetcode-cn.com/problems/words-frequency-lcci/
 */
public class WordsFrequency {

    private final HashMap<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();

        for (String s : book) {
            map.merge(s, 1, Integer::sum);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }

}
