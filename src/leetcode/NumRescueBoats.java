package leetcode;

import java.util.Arrays;

/**
 * 救生艇
 * https://leetcode-cn.com/problems/boats-to-save-people/description/
 * @author bwt
 *
 *	思路：
 *	贪心算法，因为最多能够承受两个人，所以比较简单；排序之后，使用双指针，假如 最重的人 与 最轻的人 
 *相加后大于 limit，那么最重的人只能单独一次运载(后面的指针前移，运载数++)，否则的话就可加上当前
 *最轻的人，然后两个指针都向中间靠拢。
 */
public class NumRescueBoats {

	public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
		
        int res = 0;
        int p = 0, q = people.length - 1;
        while(p <= q) {
    		if (people[q] + people[p] <= limit)
    			p++;
        	
        	res++;
			q--;
        }
		
		return res;
    }
	
	public static void main(String[] args) {
		int[] people = new int[] {
				1,2
		};
		System.err.println(numRescueBoats(people, 3));
	}
}
