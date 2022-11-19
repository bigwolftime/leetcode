package leetcode;

import java.util.*;

/**
 * 匹配子序列的单词数
 * https://leetcode.cn/problems/number-of-matching-subsequences/
 *
 * 构造一个 List<List<Integer>> 26容量
 *     存储了每个字符的索引
 *
 * @author liuxin
 * @date 2022/11/18 20:54
 */
public class NumMatchingSubseq {

    private static List<List<Integer>> SEQ_IDX_LIST;
    private static int[] IDX_ARR;
    private static Set<String> PASS_RESULT_SET;
    private static Set<String> NO_PASS_RESULT_SET;

    private static int numMatchingSubseq(String s, String[] words) {
        SEQ_IDX_LIST = new ArrayList<>();
        PASS_RESULT_SET = new HashSet<>();
        NO_PASS_RESULT_SET = new HashSet<>();

        buildSeqIdxList(s);

        int matchCnt = 0;
        for (String word : words) {
            if (PASS_RESULT_SET.contains(word)) {
                matchCnt++;
            }  else if (NO_PASS_RESULT_SET.contains(word)) {
                continue;
            }

            if (isMatch(word)) {
                matchCnt++;
                PASS_RESULT_SET.add(word);
            } else {
                NO_PASS_RESULT_SET.add(word);
            }
        }

        return matchCnt;
    }

    private static void buildSeqIdxList(String s) {
        for (int i = 0; i < 26; i++) {
            SEQ_IDX_LIST.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 97;

            List<Integer> subList = SEQ_IDX_LIST.get(idx);
            subList.add(i);
        }
    }

    private static boolean isMatch(String s) {
        int progressIdx = -1;
        IDX_ARR = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 97;

            List<Integer> subList = SEQ_IDX_LIST.get(idx);
            int tempProgressIdx = orderSearch(idx, subList, progressIdx);
            if (tempProgressIdx == -1 || tempProgressIdx <= progressIdx) {
                return false;
            }

            progressIdx = tempProgressIdx;
        }

        return true;
    }

    private static int orderSearch(int idx, List<Integer> subList, int targetVal) {
        for (int i = IDX_ARR[idx]; i < subList.size(); i++) {
            Integer val = subList.get(i);
            if (val > targetVal) {
                IDX_ARR[idx] = i;
                return val;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        /**
         * "rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac"
         * ["wpddkvbnn","lnagtva","kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju","rwpddkvbnnugln","gloeofnpjqlkdsqvruvabjrikfwronbrdyyj","vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos","mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina","rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip","fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq","qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"]
         */
        int abcde = numMatchingSubseq("dsahjpjauf", new String[]{"dsahjpjauf","ahjpjau","ja","ahbwzgqnuk","tnmlanowax"});
        System.err.println(abcde);
    }

}
