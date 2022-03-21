package org.wys.demo.tree;

import cn.hutool.core.lang.Dict;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author wys
 * @date 2022/3/18
 */
@Data
public class DictTree {

    private char node;
    private List<DictTree> next;
    private List<DictTree> heads;

    public DictTree() {
    }

    public DictTree(String s) {
        if (s != null && s.length() > 0) {
            buildTree(s);
        } else {
            throw new RuntimeException("字符串不能为空");
        }
    }

    /**
     * 构建字典树
     *
     * @param s 字符串
     */
    public void buildTree(String s) {
        DictTree head = null;
        if (this.getHeads() != null && this.heads.size() > 0) {
            for (DictTree node : heads) {
                //如果存在
                if (node.getNode() == s.charAt(0)) {
                    head = node;
                    break;
                }
            }
        }
        buildTree(null, head, s, 0);
    }

    private void buildTree(DictTree fatherNode, DictTree node, String s, int cnt) {
        if (Objects.nonNull(node)) {
            if (s.length() > cnt) {
                int index = -1;
                if (node.getNext() != null && node.getNext().size() > 0) {
                    for (int j = 0; j < node.getNext().size(); j++) {
                        if (node.getNext().get(j).getNode() == s.charAt(cnt)) {
                            index = j;
                            break;
                        }
                    }
                }
                DictTree childNode = new DictTree();
                childNode.setNode(s.charAt(cnt));
                if (index == -1) {
                    List<DictTree> nextNodes = new ArrayList<>();
                    if (fatherNode == null) {
                        if (node.getNext() == null) {
                            node.setNext(nextNodes);
                            node.getNext().add(childNode);
                            buildTree(node, node.getNext().get(0), s, ++cnt);
                        }
                    } else if (fatherNode.getNext() == null) {
                        fatherNode.setNext(nextNodes);
                        fatherNode.setNext(nextNodes);
                        fatherNode.getNext().add(childNode);
                        buildTree(fatherNode, fatherNode.getNext().get(0), s, ++cnt);
                    }
                } else {
                    buildTree(node, node.getNext().get(index), s, ++cnt);
                }
            }
        } else {

        }
    }

    private void printTree() {
        if (this.getHeads() == null || this.getHeads().size() == 0) {
            return;
        }
        for (DictTree head : this.getHeads()) {
            System.out.print("head: " + head.getNode() + " ");
            if (head.getNext() != null && head.getNext().size() > 0) {
                for (DictTree node : head.getNext()) {
                    printNode(node);
                }
            }
        }
    }

    private void printNode(DictTree node) {
        if (node.getNext() == null || node.getNext().size() == 0) {
            return;
        }
        System.out.print(node.getNode());
        for (DictTree tree : node.getNext()) {
            printNode(tree);
        }
    }

    public static void main(String[] args) {
        DictTree dictTree = new DictTree("abc");
        dictTree.buildTree("abd");
        dictTree.printTree();
    }

}
