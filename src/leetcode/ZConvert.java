package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author liuxin
 * @time 2020/6/22 19:35
 */
public class ZConvert {

    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> resList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            resList.add(sb);
        }

        int rowIdx = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            resList.get(rowIdx).append(s.charAt(i));

            if (rowIdx + 1 == numRows) {
                down = false;
            } else if (rowIdx == 0) {
                down = true;
            }
            rowIdx = down ? rowIdx + 1 : rowIdx - 1;
        }

        StringBuilder resBuilder = new StringBuilder();
        for (StringBuilder sb : resList) {
            resBuilder.append(sb);
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        System.err.println(convert("AB", 2));
        ;
        // LCIR ETOESIIG EDHN
    }

}
