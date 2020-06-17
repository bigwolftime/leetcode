package leetcode;

/**
 * 对角线遍历
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/774/
 * @author bwt
 * 
 * 没有解决。。。
 *
 */
public class FindDiagonalOrder {

	public static int[] findDiagonalOrder(int[][] matrix) {
		int maxRow = matrix.length, maxCol = matrix[0].length;
		
		if (maxRow == 1)	//一行
			return matrix[0];
		if (maxCol == 1) {	//一列
			int[] res = new int[maxRow];
			for (int i = 0; i < maxRow; i++)
				res[i] = matrix[i][0];
			return res;
		}
		
		int index = 0;
		int row = 0, col = 0;
		int curRow = 0, curCol = 0;
		int[] res = new int[maxRow * maxCol];
		
		while(row < maxRow && col < maxCol) {
			for (; curRow <= row && curCol <= col; curRow++, curCol++) {
				res[index] = matrix[curRow][curCol];
				System.err.println(matrix[curRow][curCol]);
			}
			
			if (row != maxCol - 1)
				row++;
			
			if (col != maxRow - 1)
				col++;
			
		}
		
		
        return new int[] {1};
    }
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		for (int i : findDiagonalOrder(matrix)) {
			System.err.print(" " + i + " ");
		}
		
	}
}
