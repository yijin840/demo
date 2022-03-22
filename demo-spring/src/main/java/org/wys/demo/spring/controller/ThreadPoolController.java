package org.wys.demo.spring.controller;

import org.wys.demo.design.build.Response;
import org.wys.demo.design.build.ResponseUtil;
import org.wys.demo.thread.pool.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author wys
 * @date 2021/6/29 5:00 下午
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ThreadPoolController {

    private final Task task;
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;
    private static volatile boolean IS_COMMIT = true;
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5
            , 5
            , 1
            , TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(5)
            , Executors.defaultThreadFactory()
            , new ThreadPoolExecutor.AbortPolicy());

    @RequestMapping("/executeTask")
    public String testThreadPoolTask() {
        task.currentTask();
        return "true";
    }

    @RequestMapping("/batch")
    public String batchSaveData() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for(int i=0;i<500000;i++) {
            String sql = "insert into user(username) values(?)";
            jdbcTemplate.update(sql, UUID.randomUUID().toString().substring(0, 4) + i);
        }
        stopWatch.stop();
        log.info("数据插入完毕，耗时：{}", stopWatch.getTotalTimeMillis());
        return "OK";
    }

    @RequestMapping("/save")
    public String saveData() throws ExecutionException, InterruptedException {
        List<TransactionStatus> transactionStatuses = Collections.synchronizedList(new ArrayList<>());
        List<Boolean> flagList = Collections.synchronizedList(new ArrayList<>());
        int maxThreadCount = 2;
        CountDownLatch countDownLatch = new CountDownLatch(maxThreadCount);
        CountDownLatch mainCountDownLatch = new CountDownLatch(1);
        threadPoolExecutor.submit(() -> {
            // 使用这种方式将事务状态都放在同一个事务里面
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
            TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
            try {
                transactionStatuses.add(status);
                for (int i = 1; i <= 10; i++) {
                    String sql = "insert into user(username) values(?)";
                    if (i == 9) {
                        throw new RuntimeException("手动错误");
                    }
                    jdbcTemplate.update(sql, UUID.randomUUID().toString().substring(0, 4) + i);
                }
                log.info("线程A正常执行结束，等待主线程通知...");
                countDownLatch.countDown();
                mainCountDownLatch.await();
                if(IS_COMMIT) {
                    transactionManager.commit(status);
                    log.info("主线程通知可以提交，线程A已经提交");
                }else{
                    log.info("主线程通知需要回滚，线程A已经回滚");
                    transactionManager.rollback(status);
                }
            } catch (Exception e) {
                flagList.add(false);
                transactionManager.rollback(status);
                log.info("线程A插入数据异常，已经回滚！");
                countDownLatch.countDown();
            }
        });
        threadPoolExecutor.submit(() -> {
            // 使用这种方式将事务状态都放在同一个事务里面
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
            TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
            try {
                for (int i = 99; i >= 90; i--) {
                    transactionStatuses.add(status);
                    String sql = "insert into user(username) values(?)";
                    jdbcTemplate.update(sql, UUID.randomUUID().toString().substring(0, 4) + i);
                }
                log.info("线程B正常执行结束，等待主线程通知...");
                countDownLatch.countDown();
                mainCountDownLatch.await();
                if (IS_COMMIT) {
                    transactionManager.commit(status);
                    log.info("主线程通知可以提交，线程B已经提交");
                } else {
                    transactionManager.rollback(status);
                    log.info("主线程通知需要回滚，线程B已经回滚");
                }
            } catch (Exception e) {
                flagList.add(false);
                transactionManager.rollback(status);
                log.info("线程B插入数据异常，已经回滚！");
                countDownLatch.countDown();
            }
        });
        log.info("countdownlatch ===> {}", countDownLatch);
        countDownLatch.await();
        log.info("子线程全部执行结束，开始判断是否回滚.....");
        if (flagList.size() > 0) {
            IS_COMMIT = false;
            log.info("子线程出现异常，开始回滚.....");
        } else {
            log.info("子线程没有异常，执行结束！");
        }
        mainCountDownLatch.countDown();
        return "OK";
    }

    @RequestMapping("/success")
    public Response checkSuccess() {
        return ResponseUtil.success(Boolean.TRUE);
    }

}
