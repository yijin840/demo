package org.wys.demo.structure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wys
 * @date 2021/11/21 3:03
 * @desc 二叉树工具类
 */
public class BinaryTreeUtil {

    /**
     * build二叉树
     *
     * @return root节点
     */
    private static BinaryTree buildBinaryTree() {
        BinaryTree root = new BinaryTree();
        root.setData(1);
        BinaryTree left = new BinaryTree();
        left.setData(2);
        BinaryTree right = new BinaryTree();
        right.setData(3);
        root.setLeftNode(left);
        root.setRightNode(right);
        BinaryTree left1 = new BinaryTree();
        left1.setData(4);
        BinaryTree right1 = new BinaryTree();
        right1.setData(5);
        left.setLeftNode(left1);
        left.setRightNode(right1);
        BinaryTree left2 = new BinaryTree();
        left2.setData(6);
        BinaryTree right2 = new BinaryTree();
        right2.setData(7);
        right.setLeftNode(left2);
        right.setRightNode(right2);
        left1.setRightNode(null);
        left1.setLeftNode(null);
        left2.setLeftNode(null);
        left2.setRightNode(null);
        right1.setLeftNode(null);
        right1.setRightNode(null);
        right2.setLeftNode(null);
        right2.setRightNode(null);
        return root;
    }


    /**
     * 二叉树前序遍历   根-> 左-> 右
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraverse(BinaryTree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderTraverse(node.getLeftNode());
        preOrderTraverse(node.getRightNode());
    }

    /**
     * 二叉树中序遍历   左-> 根-> 右
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraverse(BinaryTree node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeftNode());
        System.out.print(node.getData() + " ");
        inOrderTraverse(node.getRightNode());
    }

    /**
     * 二叉树后序遍历   左-> 右-> 根
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraverse(BinaryTree node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.getLeftNode());
        postOrderTraverse(node.getRightNode());
        System.out.print(node.getData() + " ");
    }

    public static void levelOrder(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        BinaryTree node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.getData() + " ");
            if (node.getLeftNode() != null) {
                queue.offer(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.offer(node.getRightNode());
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree root = buildBinaryTree();
        preOrderTraverse(root);
        System.out.println();
        inOrderTraverse(root);
        System.out.println();
        postOrderTraverse(root);
        System.out.println();
        levelOrder(root);
    }
}
