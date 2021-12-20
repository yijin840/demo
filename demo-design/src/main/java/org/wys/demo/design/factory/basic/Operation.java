package org.wys.demo.design.factory.basic;

import lombok.Data;

/**
 * @author wys
 * @date 2020/11/16 2:04 下午
 */
@Data
public abstract class Operation {
    public int left;
    public int right;
    abstract public int getResult();
}
