package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现一个魔法字典
 * https://leetcode.cn/problems/implement-magic-dictionary/
 *
 * @author liuxin
 * @date 2022/7/11 8:12 PM
 */
public class MagicDictionary {

    private List<String> dataList;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        dataList = Arrays.stream(dictionary).collect(Collectors.toList());
    }

    public boolean search(String searchWord) {
        for (String data : dataList) {
            if (matchWord(searchWord, data)) {
                return true;
            }
        }

        return false;
    }

    private boolean matchWord(String searchWord, String data) {
        if (searchWord.length() != data.length()) {
            return false;
        }

        int diff = 0;
        int idx = -1;
        while (diff <= 1 && ++idx < data.length()) {
            if (searchWord.charAt(idx) == data.charAt(idx)) {
                continue;
            }

            diff++;
        }

        return diff == 1;
    }


    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();

        magicDictionary.buildDict(new String[]{ "hello", "leetcode" });

        System.err.println(magicDictionary.search("helll"));
        System.err.println(magicDictionary.search("hello"));
    }

}
