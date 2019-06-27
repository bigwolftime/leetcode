import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Liuxin
 * @Date 2019/2/26 16:55
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 思路：中序遍历
 */
public class isSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null){
            while(cur.left != null){
                stack.push(root.left);
                cur = cur.left;
            }
            //找到最底层的左节点

            while (!stack.empty()){
                cur = stack.pop();
                list.add(cur.val);
            }

            cur = cur.right;
            if (stack.empty()){
                break;
            }
        }




        return false;
    }
}
