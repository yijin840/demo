package org.wys.demo.structure.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
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

    private void buildHead(String ch) {
        if (ch == null || ch.equals("") || ch.length() > 1) {
            return;
        }
        DictTree childNode = new DictTree();
        childNode.setNode(ch.charAt(0));
        if (this.getHeads() == null) {
            this.setHeads(new ArrayList<>());
        }
        this.getHeads().add(childNode);
    }

    private boolean isChildTree(String s) {
        if (s == null || s.equals("") || s.length() <= 1) {
            return false;
        }
        if (this.getHeads() == null || this.getHeads().size() == 0) {
            return false;
        }
        for (DictTree tree : this.getHeads()) {
            if (s.charAt(0) == tree.node) {
                return isChildTree(tree, s, 1);
            }
        }
        return false;
    }

    private boolean isChildTree(DictTree node, String s, int cnt) {
        if (cnt >= s.length()) {
            return true;
        } else {
            if(node.getNext() == null || node.getNext().size() < 1) {
                return false;
            }
        }
        if (node.getNext() != null && node.getNext().size() > 0) {
            for (DictTree tree : node.getNext()) {
                if (tree.getNode() == s.charAt(cnt)) {
                    return isChildTree(tree, s, ++cnt);
                }
            }
        }
        return false;
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

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"});
        DictTree dictTree = new DictTree("abcd");
        System.out.println(dictTree.isChildTree("abc"));
    }

    static class Solution {
        private List<String> list = new ArrayList<>();

        public String longestWord(String[] words) {
            Arrays.sort(words);
            DictTree tree = new DictTree();
            for (int i = 0; i < words.length; i++) {
                tree.buildTree(words[i]);
            }
            return null;
        }
    }

}
