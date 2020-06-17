package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Fizz Buzz
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 * @author bwt
 *
 */
public class FizzBuzz {

	public static List<String> fizzBuzz(int n) {
		LinkedList<String> res = new LinkedList<>();
		int i = 1;
		while(i <= n) {
			if (i % 3 == 0 && i % 5 == 0)
				res.add("leetCode.FizzBuzz");
			else if (i % 3 == 0)
				res.add("Fizz");
			else if (i % 5 == 0)
				res.add("Buzz");
			else
				res.add(String.valueOf(i));
			i++;
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		System.err.println(fizzBuzz(15));
	}
}
