/**
 * Nim 游戏
 * https://leetcode-cn.com/problems/nim-game/description/
 * @author bwt
 *
 *	思路：
 *	找到规律即可，从 1 开始，1，2，3 赢，4 输；5，6，7 赢，8 输；
 *	最后发现当 n % 4 = 0 时会输。
 */
public class CanWinNim {

	public static boolean canWinNim(int n) {
        if (n % 4 == 0)
        	return false;
        else
        	return true;
    }
	
	public static void main(String[] args) {
		System.err.println(canWinNim(2147483647));
	}
}
