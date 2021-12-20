package org.wys.demo.structure.linked;

import lombok.Data;

/**
 * @author wys
 * @date 2021/11/18 9:57
 * @since 1.0.0
 * @desc 链表结构
 */
@Data
public class Node {

    /**
     * 下个节点
     */
    private Node next;

    /**
     * 数据
     */
    private int data;
}
