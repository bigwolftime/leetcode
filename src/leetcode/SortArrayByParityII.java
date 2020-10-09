package leetcode;

/**
 * 按奇偶排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 *
 * @author liuxin
 * @time 2020/9/23 19:54
 */
public class SortArrayByParityII {

    private static int[] sortArrayByParityII(int[] A) {
        int base = 0, point = 1;
        int temp;

        while (point < A.length) {
            if ((base & 1) == 0) {
                // 偶数

                if (!((A[base] & 1) == 0)) {
                    // 此位置是 奇数, 需要置换为偶数
                    while (point < A.length) {
                        if ((A[point] & 1) == 0) {
                            temp = A[base];
                            A[base] = A[point];
                            A[point] = temp;
                            break;
                        }
                        point++;
                    }
                }
            } else {
                // 奇数

                if ((A[base] & 1) == 0) {
                    // 此位置是 偶数, 需要置换为奇数

                    while (point < A.length) {
                        if (!((A[point] & 1) == 0)) {
                            temp = A[base];
                            A[base] = A[point];
                            A[point] = temp;
                            break;
                        }
                        point++;
                    }
                }
            }

            base++;
            if (point <= base) {
                point = base + 1;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,2,5,7};
        sortArrayByParityII(a);

        for (int i : a) {
            System.err.println(i);
        }
    }

}
