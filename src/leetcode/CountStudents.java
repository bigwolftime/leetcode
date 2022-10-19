package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 无法吃午餐的学生数量
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 *
 * @author liuxin
 * @date 2022/10/19 19:59
 */
public class CountStudents {

    private static int countStudents(int[] students, int[] sandwiches) {
        List<Integer> studentList = new ArrayList<>(students.length);
        List<Integer> sandwichList = new ArrayList<>(sandwiches.length);
        for (int i = 0; i < students.length; i++) {
            studentList.add(students[i]);
            sandwichList.add(sandwiches[i]);
        }

        int continuousCount = 0;

        while (true) {
            if (sandwichList.isEmpty() || continuousCount == studentList.size()) {
                break;
            }

            if (sandwichList.get(0).equals(studentList.get(0))) {
                // match
                studentList.remove(0);
                sandwichList.remove(0);
                continuousCount = 0;
                continue;
            }

            // not match
            Integer remove = studentList.remove(0);
            studentList.add(remove);
            continuousCount++;
        }

        return continuousCount;
    }


    public static void main(String[] args) {
        int i = countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1});
        System.err.println(i);
    }

}
