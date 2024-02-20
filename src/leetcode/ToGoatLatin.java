package leetcode;

/**
 * 824. 山羊拉丁文<br/>
 * <a href="https://leetcode.cn/problems/goat-latin">...</a>
 *
 * @author liuxin
 * @date 2024/2/20 15:00
 */
public class ToGoatLatin {

    private static final String MA = "ma";

    private static String toGoatLatin(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            if (isVowel(s)) {
                // vowel: append "ma"
                sb.append(s);
            } else {
                StringBuilder curSb = new StringBuilder(s);
                char c = curSb.charAt(0);
                curSb.delete(0, 1);
                curSb.append(c);

                sb.append(curSb);
            }

            sb.append(MA);

            sb.append(appendA(i));

            sb.append(" ");
        }

        // remove last space
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    private static boolean isVowel(String s) {
        char c = s.charAt(0);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static String appendA(int i) {
        StringBuilder sb = new StringBuilder();
        while (i-- >= 0) {
            sb.append("a");
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String iSpeakGoatLatin = toGoatLatin("I speak Goat Latin");
        // Imaa peaksmaaa oatGmaaaa atinLmaaaaa
        // Imaa peaksmaaa oatGmaaaa atinLmaaaaa
        System.err.println(iSpeakGoatLatin);
    }

}
