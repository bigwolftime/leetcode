package leetcode;

import java.util.HashSet;

/**
 * 独特的电子邮件地址
 * https://leetcode-cn.com/problems/unique-email-addresses/
 *
 * @author liuxin
 * @date 2020/8/31 15:35
 */
public class NumUniqueEmails {

    private static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        StringBuilder sb;
        char c;
        for (String email : emails) {
            sb = new StringBuilder();

            for (int i = 0; i < email.length(); i++) {
                c = email.charAt(i);

                if (c == '@') {
                    // 添加域名
                    sb.append(email.substring(i));
                    set.add(sb.toString());
                    break;
                } else if (c == '+') {
                    // 添加域名
                    appendSuffix(sb, i, email);
                    set.add(sb.toString());
                    break;
                } else if (c != '.') {
                    sb.append(c);
                }
            }
        }

        return set.size();
    }

    private static void appendSuffix(StringBuilder sb, int i, String email) {
        for (; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                break;
            }
        }

        sb.append(email.substring(i));
    }

    public static void main(String[] args) {
        System.err.println(numUniqueEmails(new String[]{ "test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com" }));
    }

}
