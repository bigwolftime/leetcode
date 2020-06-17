package leetcode;

/**
 * 按奇偶校验排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity/description/
 * @author bwt
 *
 */
public class SortArrayByParity {

	public static int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;
        while(l < r) {
        	if (A[l] % 2 == 0)
        		l++;
        	else if (A[r] % 2 == 1)
        		r--;
        	else
        		swapArray(A, l, r);
        }
        
		return A;
    }
	
	/*
	 * 交换数组下标 pos1 和 pos2 的数据
	 */
	public static int[] swapArray(int[] arr, int pos1, int pos2) {
		int swap = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = swap;
		return arr;
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {
			1,2,4,3
		};
		sortArrayByParity(A);
	}
}
