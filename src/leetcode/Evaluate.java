package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 替换字符串中的括号内容
 * https://leetcode-cn.com/problems/evaluate-the-bracket-pairs-of-a-string/
 */
public class Evaluate {

    private static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map;
        if (knowledge == null || knowledge.size() == 0) {
            map = new HashMap<>();
        } else {
            map = knowledge.stream().collect(Collectors.toMap(list -> list.get(0), list -> list.get(1)));
        }

        StringBuilder sb = new StringBuilder(s);
        int index = 0;

        while (index < sb.length()) {

            int[] parseKeyIndexArr = parseKeyIndex(sb, index);
            if (parseKeyIndexArr == null) {
                break;
            }

            String key = sb.substring(parseKeyIndexArr[0] + 1, parseKeyIndexArr[1]);
            String value = map.get(key);
            if (value != null) {
                sb.replace(parseKeyIndexArr[0], parseKeyIndexArr[1] + 1, value);
            } else {
                sb.replace(parseKeyIndexArr[0], parseKeyIndexArr[1] + 1, "?");
            }

            index = parseKeyIndexArr[0];
        }

        return sb.toString();
    }

    private static int[] parseKeyIndex(StringBuilder sb, int startIndex) {
        boolean parseFlag = false;
        while (startIndex < sb.length()) {
            if (sb.charAt(startIndex) == '(') {
                parseFlag = true;
                break;
            }
            startIndex++;
        }

        if (!parseFlag) {
            return null;
        }

        int endIndex = startIndex + 1;
        while (endIndex < sb.length()) {
            if (sb.charAt(endIndex) == ')') {
                return new int[]{ startIndex, endIndex };
            }
            endIndex++;
        }

        return null;
    }

    public static void main(String[] args) {
        List<List<String>> knowledge = new ArrayList<>();

        List<String> subList1 = new ArrayList<>();
        subList1.add("name");
        subList1.add("bob");

        List<String> subList2 = new ArrayList<>();
        subList2.add("age");
        subList2.add("two");

        knowledge.add(subList1);
        knowledge.add(subList2);


        evaluate("(name)is(age)yearsold", knowledge);
    }

}
