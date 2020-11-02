package leetcode;

import java.util.*;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author bwt
 *
 */
public class Intersection {

	public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for (int val : nums1){
        	set.add(val);
		}

        for (int val : nums2){
        	if (set.contains(val)){
        		res.add(val);
			}
		}

        int[] arr = new int[res.size()];
        int index = 0;
		for (int val : res) {
			arr[index++] = val;
		}

		return arr;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2,2,1};
		int[] nums2 = new int[] {2,2};

		int[] res = intersection(nums1, nums2);
		for (int i : res){
			System.err.println(i);
		}
	}
}
