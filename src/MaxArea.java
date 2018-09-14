/**
 * 盛水最多的容器
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 * @author bwt
 *
 *	思路：
 *	1、暴力解法，两层循环。时间复杂度 O(n^2)，计算 n(n-1)/2；空间复杂度 O(1).
 *	2、双指针：l 指向数组首，r 指向数组尾，计算每一步的结果后于 res 比较；然后那个指针指向的
 *数值小就向中间靠拢。时间复杂度 O(n)
 *	https://leetcode-cn.com/articles/container-with-most-water/
 *	https://discuss.leetcode.com/topic/3462/yet-another-way-to-see-what
 *-happens-in-the-o-n-algorithm
 */
public class MaxArea {

	public static int maxArea(int[] height) {
		int res = 0, cur;
		
		int l = 0, r = height.length - 1;
		while(l < r) {
			cur = (r - l) * Math.min(height[l], height[r]);
			res = Math.max(cur, res);
			
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		int[] height = new int[] {
			1,8,6,2,5,4,8,3,7
		};
		
		maxArea(height);
	}
}
