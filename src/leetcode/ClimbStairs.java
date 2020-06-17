package leetcode;

/**
 * 爬楼梯
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
 * @author bwt
 *
 *	思路：
 *	动态规划图解：https://www.sohu.com/a/153858619_466939
 *	要到达 N 阶楼梯，那么最后一步有两种可能：在 N-2 阶处走 2 阶、在 N-1 处走 1 阶，
 *假设走到 N-1 处有 X 种走法，走到 N-2 处有 Y 种走法，那么走到 N 阶则表示为：F(N) = F(N - 1) + F(N - 2)，
 *最原始的写法就是第一部分的注释的代码；
 *	由上面的公式可以列出一个二叉树的结构，树的高度：N-1，节点数：2^(N-1)，时间复杂度近似：O(2^N)；
 *树中每一个节点代表一次计算，发现很多计算都是重复进行的，可以使用一个 hashMap 来存储计算的出结果，下次计算之前先
 *根据键获取值，获取不到再去计算，即：备忘录算法，时间复杂度：O(N)，空间复杂度：O(N)；
 *	上面的两个思路都是：自顶向下，如果思路改成自底向上，即：F(1) = 1, F(2) = 2，那么 F(3) = F(1) + F(2)...
 *以此类推，符合斐波那契公式，只需要保留前面的两个状态，不需要保留全部状态，空间复杂度降低到：O(1)，此方法并没有使用递归。
 *动态规划核心元素：最优子结构、边界、状态转移方程式
 */
public class ClimbStairs {

	public static int climbStairs(int n) {
		/*if (n == 1 || n == 2)
			return n;
		
		return climbStairs(n - 1) + climbStairs(n - 2);*/
		
		if (n == 1 || n == 2)
			return n;
		
		int a = 1, b = 2;
		int temp = 0;
		
		for (int i = 3; i <= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		
		return temp;
    }
	
	public static void main(String[] args) {
		System.err.println(climbStairs(10));
	}
}
