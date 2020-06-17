package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/description/
 * @author bwt
 *
 */
public class RomanToInt {

	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == 'I') {
        		if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
        			res += 4;
        			i++;
        		}else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
        			res += 9;
        			i++;
        		}else 
    				res += map.get(s.charAt(i));
        	}else if (s.charAt(i) == 'X') {
        		if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
        			res += 40;
        			i++;
        		}else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
        			res += 90;
        			i++;
        		}else 
    				res += map.get(s.charAt(i));
			}else if (s.charAt(i) == 'C') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
					res += 400;
					i++;
				}else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
					res += 900;
					i++;
				}else 
					res += map.get(s.charAt(i));
			}else 
				res += map.get(s.charAt(i));
        }
        
		return res;
    }
	
	public static void main(String[] args) {
		romanToInt("MCMXCIV");
	}
}
