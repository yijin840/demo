package org.wys.demo.jvm.lock;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author wys
 * @date 2022/4/28
 */
@Slf4j
public class DeviationLock {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        log.info("未进入同步代码块，当前Mark Word为:");
        log.info("{}", ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            log.info("进入同步代码块，当前Mark Word为:");
            log.info("{}", ClassLayout.parseInstance(o).toPrintable());
        }

    }

}
