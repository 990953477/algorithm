package com.ustc.nowcoder.tree;

import com.ustc.nowcoder.TreeNode;

/**
 * 判断是否是平衡二叉树
 *
 * @author tangfeng
 * @since 2019年08月28日 11:02
 */
public class Question06 {
    private boolean isBlance = true;
    private boolean isAsc = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        //空树也是平衡二叉树
        if (root == null || (root.left == null && root.right == null))
            return true;
        getDepth(root);
        return isBlance;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBlance = false;
        }

        return right > left ? right + 1 : left + 1;
    }
}
