package leetcode;

import utils.TreeNode;

/**
 * 将有序数组转化为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * 使用递归.
 *
 * shit 一样的代码, 估计过两天自己也看不出是啥意思了.
 *
 * @author liuxin
 * @time 2020/7/3 15:51
 */
public class SortedArrayToBST {

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        if (nums.length == 2) {
            TreeNode root = new TreeNode(nums[0]);
            root.right = new TreeNode(nums[1]);
            return root;
        }

        int mid = (nums.length - 1) >> 1;

        TreeNode root = new TreeNode(nums[mid]);

        buildLeftBST(root, nums, 0, mid - 1);
        buildRightBST(root, nums, mid + 1, nums.length - 1);

        return root;
    }

    private static void buildLeftBST(TreeNode node, int[] nums, int leftStart, int leftEnd) {
        int leftMid = (leftStart + leftEnd) >> 1;
        if (leftStart + 1 == leftEnd) {
            TreeNode leftNode = new TreeNode(nums[leftStart]);
            leftNode.right = new TreeNode(nums[leftEnd]);

            node.left = leftNode;
        } else if (leftStart == leftEnd) {
            node.left = new TreeNode(nums[leftStart]);
        } else {
            node.left = new TreeNode(nums[leftMid]);
            node = node.left;

            buildLeftBST(node, nums, leftStart, leftMid - 1);
            buildRightBST(node, nums, leftMid + 1, leftEnd);
        }
    }

    private static void buildRightBST(TreeNode node, int[] nums, int rightStart, int rightEnd) {
        int rightMid = (rightStart + rightEnd) >> 1;
        if (rightStart + 1 == rightEnd) {
            TreeNode rightNode = new TreeNode(nums[rightStart]);
            rightNode.right = new TreeNode(nums[rightEnd]);

            node.right = rightNode;
        } else if (rightStart == rightEnd) {
            node.right = new TreeNode(nums[rightStart]);
        } else {
            node.right = new TreeNode(nums[rightMid]);
            node = node.right;

            buildRightBST(node, nums, rightMid + 1, rightEnd);
            buildLeftBST(node, nums, rightStart, rightMid - 1);
        }
    }


    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{0, 1});

        System.err.println("x");
    }

}
