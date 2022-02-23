package org.wys.demo.common.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerContext;

import java.util.logging.LogRecord;

import static ch.qos.logback.classic.Logger.FQCN;

/**
 * @author wys
 * @date 2022/2/23
 */
public final class Logger {

    private static final Integer DEBUG = -1;

    private static final Integer INFO = 0;

    private static final Integer WARN = 1;

    private static final Integer ERROR = 2;

    private static final LoggerContext loggerContext =
            LogManager.getContext(Logger.class.getClassLoader(), false);

    private final ExtendedLogger loggerExt;

    private Logger() {
        LoggerContext context = loggerContext;
        if (context == null) {
            // Circular call in early-init scenario -> static field not initialized yet
            context = LogManager.getContext(Logger.class.getClassLoader(), false);
        }
        this.loggerExt = context.getLogger("logger");
    }


    public void info(String message) {
        this.loggerExt.logIfEnabled(FQCN, Level.valueOf("info"), null, (String) message);
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.info("你好啊");
    }

}
