package leetcode;

/**
 * 学生出勤记录 I
 * https://leetcode-cn.com/problems/student-attendance-record-i/description/
 * @author bwt
 *
 */
public class CheckRecord {

	public static boolean checkRecord(String s) {
		int aNum = 0;	//A 的次数
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A')
				aNum++;
			else if (s.charAt(i) == 'L') {
				if (i + 2 < s.length()) {
					if (s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
						return false;
				}
			}
			
			if (aNum > 1)
				return false;
		}
		
        return true;
    }
	
	public static void main(String[] args) {
		boolean res = checkRecord("PPALLL");
		System.err.println(res);
	}
}
