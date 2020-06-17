package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @author liuxin
 * @time 2020/6/16 18:46
 */
public class Generate {

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if (numRows == 0) {
            return list;
        }

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        list.add(firstList);

        if (numRows == 1) {
            return list;
        }

        List<Integer> secList = new ArrayList<>();
        secList.add(1);
        secList.add(1);
        list.add(secList);

        if (numRows == 2) {
            return list;
        }

        numRows -= 2;

        List<Integer> tempList;
        int index;
        while (numRows-- > 0) {
            index = 1;
            tempList = list.get(list.size() - 1);

            List<Integer> newList = new ArrayList<>();
            newList.add(1);

            while (index + 1 <= tempList.size()) {
                newList.add(tempList.get(index) + tempList.get(index - 1));
                index++;
            }

            newList.add(1);

            list.add(newList);
        }

        return list;
    }

    public static void main(String[] args) {
        System.err.println(generate(6));;
    }

}
