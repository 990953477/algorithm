package com.ustc.nowcoder.tree;

import com.ustc.nowcoder.TreeLinkNode;

/**
 * 二叉树的下一个结点
 * 题目:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author tangfeng
 * @since 2019年08月31日 13:20
 */
public class Question21 {
    public static void main(String[] args) {

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //找到他的根节点
        TreeLinkNode currentNode = pNode;
        while (currentNode != null) {
            currentNode = currentNode.next;
        }

        TreeLinkNode root = currentNode;

        return null;
    }

    public TreeLinkNode subTree(TreeLinkNode pNode){
        if (pNode == null)
            return null;
        subTree(pNode.left);
        subTree(pNode.right);

        return pNode;
    }
}
