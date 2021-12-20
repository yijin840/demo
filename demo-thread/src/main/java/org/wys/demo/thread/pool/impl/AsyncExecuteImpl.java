package org.wys.demo.thread.pool.impl;

import org.wys.demo.thread.pool.AsyncExecute;
import org.wys.demo.thread.pool.ExecuteTarget;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2021/6/29 4:45 下午
 */
@Component
@RequiredArgsConstructor
public class AsyncExecuteImpl implements AsyncExecute {
    @Async("threadPoolTaskExecutor")
    @Override
    public void executeTask(ExecuteTarget executeTarget) {
        try{
            executeTarget.executeTarget();
        }catch (Exception e) {
            throw new RuntimeException("线程池执行异常");
        }
    }
}
