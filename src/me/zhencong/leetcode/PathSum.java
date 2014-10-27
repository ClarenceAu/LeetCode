package me.zhencong.leetcode;

/**
 * @author <a href="zhencong.ouzc@taobao.com">遣怀</a>
 * @date 14/10/27.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && sumLeaf(root, 0, sum);
    }

    private boolean sumLeaf(TreeNode root, int acc, int sum) {
        if (root.left == null && root.right == null) {
            return acc + root.val == sum;
        } else {
            acc += root.val;
            boolean flag = false;
            if (root.left != null) {
                flag = sumLeaf(root.left, acc, sum);
            }
            if (!flag && root.right != null) {
                flag = sumLeaf(root.right, acc, sum);
            }
            return flag;
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

}
