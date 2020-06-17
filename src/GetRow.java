import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 *
 * @author liuxin
 * @time 2020/6/17 15:54
 */
public class GetRow {

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        if (rowIndex == 0) {
            return firstList;
        }

        List<Integer> secList = new ArrayList<>();
        secList.add(1);
        secList.add(1);

        List<Integer> tempList = secList;

        int index;
        rowIndex -= 1;
        while (rowIndex-- > 0) {
            index = 1;

            List<Integer> newList = new ArrayList<>();
            newList.add(1);

            while (index + 1 <= tempList.size()) {
                newList.add(tempList.get(index) + tempList.get(index - 1));
                index++;
            }

            newList.add(1);

            tempList = newList;
        }

        return tempList;
    }

    public static void main(String[] args) {
        System.err.println(getRow(0));
    }

}
