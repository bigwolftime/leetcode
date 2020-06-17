package leetcode;

/**
 * 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * @author liuxin
 * @time 2020/5/25 20:50
 */
public class CanFinish {

    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < prerequisites.length; i++) {
            System.err.println(prerequisites[i][0]);
            System.err.println(prerequisites[i][1]);
        }

        return false;
    }

    public static void main(String[] args) {
        canFinish(2, new int[][]{ {1,0}, {0,1} });
    }

}
