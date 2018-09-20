/**
 * 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/description/
 * @author bwt
 * 
 */
public class LemonadeChange {

	public static boolean lemonadeChange(int[] bills) {
        int fiveNum = 0, tenNum = 0;
        
        for (int i : bills) {
			if (i == 5) {	//5 元无需找零
				fiveNum++;
			}else if (i == 10) {	//客户支付 10 元只能找零一个 5 元
				tenNum++;
				
				if (fiveNum <= 0)
					return false;
				else
					fiveNum--;
			}else {	//用户支付 20 元找零：10 + 5 或者 5 + 5 + 5
				if (fiveNum < 1)	//两种方式都至少需要一张 5 元
					return false;
				else {
					if (tenNum >= 1) {
						tenNum--;
						fiveNum--;
					}else {
						if (fiveNum >= 3)
							fiveNum -= 3;
						else
							return false;
					}
				}
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		int[] bills = new int[] {
				5,5,10,10,20
		};
		System.err.println(lemonadeChange(bills));
	}
}
