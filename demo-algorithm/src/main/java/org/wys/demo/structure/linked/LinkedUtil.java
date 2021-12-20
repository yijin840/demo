package org.wys.demo.structure.linked;

import java.util.Objects;

/**
 * @author wys
 * @date 2021/11/18 10:03
 * @desc 链表工具类
 * @since 1.0.0
 */
public class LinkedUtil {


    public static Node buildLinkedData() {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        node1.setData(1);
        node2.setData(1);
        node3.setData(3);
        node4.setData(4);
        node5.setData(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);

        return node1;
    }

    /**
     * 反转链表
     *
     * @param head 头节点
     * @return 返回一个头节点
     */
    public static Node reverse(Node head) {

        /*
            cur = 1, pre = null, next = 2
            cur = 2, pre = 1, next = 3
            ......
            cur = null, pre = 5, next = null;
            return pre
         */
        if (head == null || head.getNext() == null) {
            return head;
        }
        //当前节点
        Node cur = head;
        //前驱节点
        Node preCur = null;
        //后置节点
        Node nextCur = cur.getNext();
        while (cur != null) {
            cur.setNext(preCur);
            preCur = cur;
            cur = nextCur;
            if(Objects.nonNull(nextCur)) {
                nextCur = nextCur.getNext();
            }
        }
        return preCur;
    }

    public static void main(String[] args) {
        Node node = buildLinkedData();
        node = reverse(node);
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

}
