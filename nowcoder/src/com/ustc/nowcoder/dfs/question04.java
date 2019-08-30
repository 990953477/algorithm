package com.ustc.nowcoder.dfs;

import com.ustc.nowcoder.TreeNode;

/**
 * @author tangfeng
 * @since 2019年08月27日 21:25
 */
public class question04 {
    public int max = 0;
    public int count= 0;
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        count++;
        subTree(root.left);
        subTree(root.right);
        return max;
    }

    public void subTree(TreeNode root){
        if(root == null){
            max = Math.max(max, count);
            return;
        }
        count++;
        subTree(root.left);
        count--;
        subTree(root.right);
        count--;
    }
}
