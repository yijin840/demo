package org.wys.demo.structure.tree;

import lombok.Data;

import java.util.ArrayList;
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
        int cnt = 0;
        if (this.getHeads() != null && this.heads.size() > 0) {
            for (DictTree node : heads) {
                //如果存在
                if (node.getNode() == s.charAt(0)) {
                    head = node;
                    ++cnt;
                    break;
                }
            }
        }
        buildTree(head, s, cnt);
    }

    private void buildTree(DictTree node, String s, int cnt) {
        if (cnt >= s.length()) return;
        int index = -1;
        DictTree childNode = new DictTree();
        childNode.setNode(s.charAt(cnt));
        if (Objects.nonNull(node)) {
            if (node.getNext() != null && node.getNext().size() > 0) {
                for (int j = 0; j < node.getNext().size(); j++) {
                    if (node.getNext().get(j).getNode() == s.charAt(cnt)) {
                        index = j;
                        break;
                    }
                }
            }
            if (index == -1) {
                List<DictTree> nextNodes = new ArrayList<>();
                if (node.getNext() == null) {
                    node.setNext(nextNodes);
                }
                node.getNext().add(childNode);
                buildTree(node.getNext().get(0), s, ++cnt);
            } else {
                buildTree(node.getNext().get(index), s, ++cnt);
            }
        } else {
            if (this.getHeads() == null) {
                List<DictTree> heads = new ArrayList<>();
                this.setHeads(heads);
            }
            this.getHeads().add(childNode);
            buildTree(childNode, s, ++cnt);
        }
    }

    private void printTree() {
        if (this.getHeads() == null || this.getHeads().size() == 0) {
            return;
        }
        for (DictTree head : this.getHeads()) {
            printNode(head);
        }
    }

    private void printNode(DictTree node) {
        System.out.print(node.getNode());
        if (node.getNext() == null || node.getNext().size() == 0) {
            return;
        }
        for (DictTree tree : node.getNext()) {
            printNode(tree);
        }
    }

    public static void main(String[] args) {
        DictTree dictTree = new DictTree("abcaabcd");
        dictTree.buildTree("abdaaa");
        dictTree.printTree();
    }

}
