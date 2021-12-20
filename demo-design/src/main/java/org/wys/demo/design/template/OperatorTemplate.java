package org.wys.demo.design.template;

/**
 * @author wys
 * @date 2021/11/30
 */
public abstract class OperatorTemplate {

    /**
     * 运行
     */
    final void run() {
        init();
        load();
        print();
    }

    abstract void init();

    abstract void load();

    abstract void print();

}
