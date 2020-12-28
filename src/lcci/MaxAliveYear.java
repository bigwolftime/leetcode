package lcci;

/**
 * 生存问题
 * https://leetcode-cn.com/problems/living-people-lcci/
 *
 * 准备一个数组，然后上下车
 */
public class MaxAliveYear {

    private static final int BASE_YEAR = 1900;

    private static int maxAliveYear(int[] birth, int[] death) {
        int[] activeArr = new int[101];

        for (int i = 0; i < birth.length; i++) {
            int birthYear = birth[i], deathYear = death[i];

            for (; birthYear <= deathYear; birthYear++) {
                activeArr[birthYear - BASE_YEAR]++;
            }

        }

        int max = activeArr[activeArr.length - 1];
        int maxYear = 0;
        for (int i = activeArr.length - 1; i >= 0; i--) {
            if (activeArr[i] >= max) {
                max = activeArr[i];
                maxYear = i;
            }
        }

        return maxYear + BASE_YEAR;
    }

    public static void main(String[] args) {

    }

}
