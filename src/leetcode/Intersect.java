package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 * @author bwt
 *
 *	思路：
 *	如果将两个数组排序的话，就可以使用双指针办法解决，每次比较：相等的话指针共同后移，不相等的话移动较小的
 *数字的指针。
 */
public class Intersect {

	public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		ArrayList<Integer> list = new ArrayList<>();
		int p = 0, q = 0;
		while(q < nums2.length && p < nums1.length) {
			if (nums1[p] < nums2[q]) {
				p++;
			} else if (nums1[p] > nums2[q]) {
				q++;
			} else {
				list.add(nums1[p]);
				p++;
				q++;
			}
		}

		int[] res = new int[list.size()];
		p = 0;
		for (int i : list) {
			res[p++] = i;
		}

        return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {
			4,9,5
		};
		int[] nums2 = new int[] {
			9,4,9,8,4
		};
		
		intersect(nums1, nums2);
	}
}
