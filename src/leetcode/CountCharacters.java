package leetcode;

/**
 * 拼写单词
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class CountCharacters {

    private static int countCharacters(String[] words, String chars) {
        int[] countArr = new int[26];
        int count = 0;

        for (int i = 0; i < chars.length(); i++) {
            countArr[chars.charAt(i) - 97]++;
        }

        for (String word : words) {
            int[] tempArr = new int[26];
            boolean flag = true;
            System.arraycopy(countArr, 0, tempArr, 0, countArr.length);

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 97;
                int rest = tempArr[idx]--;
                if (rest <= 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count += word.length();
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }

}
