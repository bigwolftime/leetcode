/**
 * @Author Liuxin
 * @Date 2019/3/13 18:50
 */
public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        int mid;

        while (start <= end){
            mid = (start + end) >> 1;

            if (isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }

            if (end - start <= 1){
                return isBadVersion(start) ? start : end;
            }
        }

        return -1;
    }

    private static boolean isBadVersion(int n){
        if (n >= 4){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.err.println(firstBadVersion(1));
    }
}
