package leetcode;

/**
 * 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Multiply {

	private static String multiply(String num1, String num2) {
		if (num1.length() < num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}

		StringBuilder resBuilder = new StringBuilder();

		StringBuilder tempBuilder;
		int base = 0;
		int flag = 0;
		int tempRes;
		boolean zeroFlag = true;
		int left;
		for (int i = num2.length() - 1; i >= 0; i--) {
			tempBuilder = new StringBuilder();

			for (int j = num1.length() - 1; j >= 0; j--) {
				tempRes = multi(num1.charAt(j), num2.charAt(i)) + flag;
				left = tempRes % 10;
				tempBuilder.insert(0, left);
				flag = tempRes / 10;

				if (zeroFlag && left != 0) {
					zeroFlag = false;
				}
			}

			if (flag > 0) {
				tempBuilder.insert(0, flag);
				flag = 0;
			}

			if (zeroFlag) {
				tempBuilder.replace(0, tempBuilder.length(), "0");
			} else {
				tempBuilder.append("0".repeat(Math.max(0, base)));
			}

			add(resBuilder, tempBuilder);

			base++;
		}

		return resBuilder.toString();
 	}

 	private static int multi(char a, char b) {
		return (a - 48) * (b - 48);
	}

	private static int add(char a, char b) {
		return a + b - 96;
	}

	private static void add(StringBuilder resBuilder, StringBuilder tempBuilder) {
		int flag = 0;
		int tempRes;
		int p = resBuilder.length() - 1, q = tempBuilder.length() - 1;

		while (p >= 0 && q >= 0) {
			tempRes = add(resBuilder.charAt(p), tempBuilder.charAt(q)) + flag;
			resBuilder.setCharAt(p, (char) (tempRes % 10 + 48));
			flag = tempRes >= 10 ? 1 : 0;

			p--;
			q--;
		}

		while (p >= 0) {
			tempRes = resBuilder.charAt(p) - 48 + flag;
			resBuilder.setCharAt(p, (char) (tempRes % 10 + 48));
			flag = tempRes >= 10 ? 1 : 0;
			p--;
		}
		while (q >= 0) {
			tempRes = tempBuilder.charAt(q) - 48 + flag;
			resBuilder.insert(0, (char) (tempRes % 10 + 48));
			flag = tempRes >= 10 ? 1 : 0;

			q--;
		}

		if (flag == 1) {
			resBuilder.insert(0, '1');
		}
	}

	public static void main (String[] args) {
		System.err.println(multiply("0", "999"));

	}

}
