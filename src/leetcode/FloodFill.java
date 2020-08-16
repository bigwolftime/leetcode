package leetcode;

/**
 * 图像渲染
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class FloodFill {

	private static int ORIGIN_COLOR;
	private static int NEW_COLOR;

	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (!validPoint(image, sr, sc)) {
			return image;
		}

		ORIGIN_COLOR = image[sr][sc];
		NEW_COLOR = newColor;

		fill(image, sr, sc);

		return image;
	}

	private static void fill(int[][] image, int x, int y) {
		if (!validPoint(image, x, y)) {
			return;
		}

		if (!validTargetColor(image, x, y)) {
			return;
		}

		if (image[x][y] == NEW_COLOR) {
			return;
		}

		image[x][y] = NEW_COLOR;

		fill(image, x - 1, y);
		fill(image, x + 1, y);
		fill(image, x, y - 1);
		fill(image, x, y + 1);
	}

	private static boolean validPoint(int[][] image, int targetX, int targetY) {
		// 坐标溢出 -> false
		return targetX >= 0 && targetX < image.length && targetY >= 0 && targetY < image[0].length;
	}

	private static boolean validTargetColor(int[][] image, int targetX, int targetY) {
		// 目标坐标 = 原坐标值
		return image[targetX][targetY] == ORIGIN_COLOR;
	}

	public static void main (String[] args) {
		floodFill(new int[][]{
				{ 0,0,0 },
				{ 0,1,1 }
		}, 1, 1, 1);
	}

}
