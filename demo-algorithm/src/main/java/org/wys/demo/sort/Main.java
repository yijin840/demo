package org.wys.demo.sort;

/**
 * @author wys
 * @date 2022/4/28
 */
public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.put(1, 1);
        redBlackTree.put(2, 2);
        redBlackTree.put(3, 3);
        redBlackTree.put(4, 4);
        redBlackTree.put(5, 5);
        redBlackTree.put(6, 6);
        redBlackTree.preOrder();
    }
}
