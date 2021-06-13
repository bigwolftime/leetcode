package leetcode;

/**
 * 第一个错误的版本
 * https://leetcode-cn.com/problems/first-bad-version/
 *
 * @Author Liuxin
 * @Date 2019/3/13 18:50
 */
public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        int mid;

        int minVersion = Integer.MAX_VALUE;

        while (start <= end){
            mid = start + ((end - start) >> 1);

            if (isBadVersion(mid)) {
                minVersion = Math.min(mid, minVersion);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minVersion;
    }

    private static boolean isBadVersion(int n){
        if (n >= 4){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.err.println(firstBadVersion(4));
    }
}
