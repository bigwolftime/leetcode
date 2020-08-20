package leetcode;

/**
 * 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 *
 * 不难, 普通的深度优先/广度优先. 不过方向有8个.
 */
public class UpdateBoard {

	private static char[][] staticBoard;

	private static char[][] updateBoard(char[][] board, int[] click) {
		staticBoard = board;

		int x = click[0], y = click[1];

		update(x, y);

		return staticBoard;
	}

	private static void update(int x, int y) {
		if (!validPoint(x, y)) {
			return;
		}

		if (staticBoard[x][y] == 'B') {
			// 空格, 已挖 -> 结束即可
			return;
		}

		if (staticBoard[x][y] == 'M') {
			// 踩雷 -> 结束
			staticBoard[x][y] = 'X';
			return;
		}

		// 此坐标周围有雷 -> 结束
		int landmineCount = landmineCount(x, y);
		if (landmineCount > 0) {
			staticBoard[x][y] = (char) (landmineCount + 48);
			return;
		} else {
			staticBoard[x][y] = 'B';
		}

		update(x + 1, y);
		update(x - 1, y);
		update(x, y + 1);
		update(x, y - 1);
		update(x + 1, y + 1);
		update(x + 1, y - 1);
		update(x - 1, y + 1);
		update(x - 1, y - 1);
	}

	/**
	 * 坐标 [x, y] 的周围有几个雷
	 * @param x
	 * @param y
	 * @return
	 */
	private static int landmineCount(int x, int y) {
		int count = 0;

		if (isLandmine(x - 1, y)) {
			count++;
		}
		if (isLandmine(x + 1, y)) {
			count++;
		}
		if (isLandmine(x, y - 1)) {
			count++;
		}
		if (isLandmine(x, y + 1)) {
			count++;
		}
		if (isLandmine(x - 1, y + 1)) {
			count++;
		}
		if (isLandmine(x - 1, y - 1)) {
			count++;
		}
		if (isLandmine(x + 1, y - 1)) {
			count++;
		}
		if (isLandmine(x + 1, y + 1)) {
			count++;
		}

		return count;
	}

	private static boolean validPoint(int x, int y) {
		// 坐标不符合 -> 结束
		return x >= 0 && x < staticBoard.length && y >= 0 && y < staticBoard[0].length;
	}

	private static boolean isLandmine(int x, int y) {
		if (!validPoint(x, y)) {
			return false;
		}
		return staticBoard[x][y] == 'M';
	}

	public static void main (String[] args) {

	}

}
