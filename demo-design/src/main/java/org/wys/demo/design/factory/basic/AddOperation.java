package org.wys.demo.design.factory.basic;

/**
 * @author wys
 * @date 2020/11/16 2:04 下午
 */
public class AddOperation extends Operation {

    @Override
    public int getResult() {
        return left+right;
    }
}
