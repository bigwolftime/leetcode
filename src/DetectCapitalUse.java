/**
 * 检测大写字母
 * https://leetcode-cn.com/problems/detect-capital/description/
 * @author bwt
 *
 *	比较基础的写法。
 */
public class DetectCapitalUse {

	public static boolean detectCapitalUse(String word) {
        boolean isUpperFirstCase = false;	//首字母大写，其余小写
        boolean allUpperCase = false;		//全部字母大写
        
		if (isUpperCase(word.charAt(0))) {	//首字母大写
			//两种情况符合：只有首字母大写，其余小写；全部字母大写
			if (word.length() >= 2) {
				if (!isUpperCase(word.charAt(1)))
					isUpperFirstCase = true;
				else
					allUpperCase = true;
				
				for (int i = 2; i < word.length(); i++) {
					if (isUpperFirstCase) {
						if (isUpperCase(word.charAt(i)))
							return false;
					}else {
						if (!isUpperCase(word.charAt(i)))
							return false;
					}
				}
			}
		}else {	//首字母小写，那么所有字母都应该小写
			for (int i = 1; i < word.length(); i++) {
				if (isUpperCase(word.charAt(i)))
					return false;
			}
		}
		
		return true;
    }
	
	public static boolean isUpperCase(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
	public static void main(String[] args) {
		String word = "Google";
		
		boolean res = detectCapitalUse(word);
		System.err.println(res);
	}
}
