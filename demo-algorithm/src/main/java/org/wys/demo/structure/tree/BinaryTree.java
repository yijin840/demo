package org.wys.demo.structure.tree;


import lombok.Data;

/**
 * @author wys
 * @date 2021/11/21 3:00
 * @desc 二叉树结构
 */
@Data
public class BinaryTree {

    private BinaryTree leftNode;
    private BinaryTree rightNode;
    private int data;

}
