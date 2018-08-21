import java.util.HashSet;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 * @author bwt
 *
 */
public class Intersection {

	public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
		
        for (int i = 0; i < nums1.length; i++) {
        	for (int j = 0; j < nums2.length; j++) {
        		if (nums1[i] == nums2[j]) {
        			hashSet.add(nums1[i]);
        			break;
        		}
        	}
        }
        
        int[] res = new int[hashSet.size()];
        int index = 0;
        for (Integer integer : hashSet) {
			res[index++] = integer;
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {4,9,5};
		int[] nums2 = new int[] {9,4,9,8,4};
		
		intersection(nums1, nums2);
	}
}
