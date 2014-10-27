package me.zhencong.leetcode;

/**
 * @author <a href="zhencong.ouzc@taobao.com">遣怀</a>
 * @date 14/10/27.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : calDepth(root, 0);
    }

    private int calDepth(TreeNode root, int acc) {
        if (root == null) {
            return acc;
        } else {
            int leftDepth = calDepth(root.left, acc + 1);
            int rightDepth = calDepth(root.right, acc + 1);
            return leftDepth > rightDepth ? leftDepth : rightDepth;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        MaximumDepthOfBinaryTree maxDepth = new MaximumDepthOfBinaryTree();
        System.out.println(maxDepth.maxDepth(null));
        System.out.println(maxDepth.maxDepth(root));

        root.left = new TreeNode(3);
        System.out.println(maxDepth.maxDepth(root));
        root.right = new TreeNode(4);
        System.out.println(maxDepth.maxDepth(root));
        root.right.right = new TreeNode(5);
        System.out.println(maxDepth.maxDepth(root));
    }

}
