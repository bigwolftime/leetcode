package leetcode;

/**
 * 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * G(n): 表示长度 n 的序列, 组成 BST 的方法数;
 * f(i, n): 表示长度为 n 的序列中, 以 i 为 root 的方法数.
 *
 * 所以: G(n) = f(1, n) + f(2, n) + ... + f(n, n).
 *
 * 以序列 { 1,2,3,4,5,6,7 } 举例, 若令 i = 2, 即以 3 为 root, 则 f(3, 7) = G(2) + G(4)
 *
 * 所以 f(i, n) = G(i - 1) + G(n - i).
 *
 * 所以 G(n) = G(0) + G(1) + G(1) + G(0) + ...
 *
 * 例如: G(3) = f(1, 3) + f(2, 3) + f(3, 3)
 *           = G(0) + G(2) + G(1) + G(1) + G(2) + G(0)
 * 其中 G(0) = G(1) = 1.
 *
 * G(2) = f(1, 2) + f(2, 2)
 *      = G(0) + G(1) + G(1) + G(0)
 *
 * 太妙了太妙了
 *
 * @author liuxin
 * @time 2020/7/15 10:44
 */
public class NumTrees {

    private static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }


    public static void main(String[] args) {
        int i = numTrees(7);
        System.err.println(i);
    }

}
