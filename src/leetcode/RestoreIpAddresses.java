package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {

	private static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		int len = s.length();

		if (len > 12) {
			return list;
		}

		String subIP;
		for (int i = 0; i < len - 3; i++) {
			for (int j = i + 1; j < len - 2; j++) {
				for (int k = j + 1; k < len - 1; k++) {
					StringBuilder sb = new StringBuilder();

					subIP = s.substring(0, i + 1);
					if (!checkSubIP(subIP)) {
						continue;
					}
					sb.append(subIP).append(".");

					subIP = s.substring(i + 1, j + 1);
					if (!checkSubIP(subIP)) {
						continue;
					}
					sb.append(subIP).append(".");

					subIP = s.substring(j + 1, k + 1);
					if (!checkSubIP(subIP)) {
						continue;
					}
					sb.append(subIP).append(".");

					subIP = s.substring(k + 1, len);
					if (!checkSubIP(subIP)) {
						continue;
					}
					sb.append(subIP);

					list.add(sb.toString());
				}
			}
		}

		return list;
	}

	private static boolean checkSubIP(String subIPStr) {
		int len = subIPStr.length();
		if (len > 3) {
			return false;
		}
		if (len > 1 && subIPStr.charAt(0) == '0') {
			return false;
		}

		int subIP = Integer.parseInt(subIPStr);
		return subIP >= 0 && subIP <= 255;
	}

	public static void main (String[] args) {
		System.err.println(restoreIpAddresses("25525511135"));
	}

}
