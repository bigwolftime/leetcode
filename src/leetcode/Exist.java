package leetcode;

/**
 * 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 *
 * 回溯, 需要注意: 对于每次循环, 不能重复取, 所以使用额外的一个数组
 *
 */
public class Exist {

	private static boolean flag;
	private static int[][] tempArr;

	private static boolean exist(char[][] board, String word) {
		flag = false;
		tempArr = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j <  board[0].length; j++) {
				dfs(i, j, board, word, 0);

				if (flag) {
					return true;
				}
			}
		}

		return false;
	}

	private static void dfs(int x, int y, char[][] board, String word, int index){
		if (index == word.length()) {
			// word 遍历完成
			flag = true;
			return;
		}

		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return;
		}

		if (flag) {
			// 如果已找到, 后面直接返回
			return;
		}

		if (tempArr[x][y] == 1) {
			// 已匹配过 -> 结束
			return;
		}

		if (word.charAt(index) != board[x][y]) {
			// 不匹配 -> 结束
			return;
		}

		tempArr[x][y] = 1;

		dfs(x - 1, y, board, word, index + 1);
		dfs(x + 1, y, board, word, index + 1);
		dfs(x, y - 1, board, word, index + 1);
		dfs(x, y + 1, board, word, index + 1);

		tempArr[x][y] = 0;
	}

	public static void main (String[] args) {
		System.err.println(exist(new char[][]{
				{ 'a' }
		}, "a"));
	}

}
