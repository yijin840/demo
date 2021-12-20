package org.wys.demo.thread.pool;

/**
 * @author wys
 * @date 2021/6/29 4:40 下午
 */
public interface AsyncExecute {

    /**
     * 执行任务
     */
    void executeTask(ExecuteTarget executeTarget);

}
