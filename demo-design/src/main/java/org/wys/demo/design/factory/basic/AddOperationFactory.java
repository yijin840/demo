package org.wys.demo.design.factory.basic;

/**
 * @author wys
 * @date 2020/11/16 2:06 下午
 */
public class AddOperationFactory implements OperationFactory{
    @Override
    public Operation createOperation() {
        return new AddOperation();
    }
}
