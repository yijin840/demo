package org.wys.demo.thread.pool;

/**
 * @author wys
 * @date 2021/6/29 4:43 下午
 */
@FunctionalInterface
public interface ExecuteTarget {

    void executeTarget() throws Exception;

}
