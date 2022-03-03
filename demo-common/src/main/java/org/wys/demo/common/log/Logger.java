package org.wys.demo.common.log;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerContext;
import org.elasticsearch.client.security.user.User;

import java.util.ArrayList;
import java.util.logging.LogRecord;

import static ch.qos.logback.classic.Logger.FQCN;

/**
 * @author wys
 * @date 2022/2/23
 */
public final class Logger {

    private static final String DEBUG = "DEBUG";

    private static final String INFO = "INFO";

    private static final String WARN = "WARN";

    private static final String ERROR = "ERROR";

    private static final LoggerContext LOGGER_CONTEXT =
            LogManager.getContext(Logger.class.getClassLoader(), false);

    private final ExtendedLogger loggerExt;

    private Logger() {
        this.loggerExt = LOGGER_CONTEXT.getLogger("logger");
    }

    public void info(String message, Object...args) {
        this.loggerExt.logIfEnabled(FQCN, Level.valueOf(INFO), null, message, args);
    }

    public void warn(String message, Object...args) {
        this.loggerExt.logIfEnabled(FQCN, Level.valueOf(WARN), null, message, args);
    }

    public void error(String message, Object...args) {
        this.loggerExt.logIfEnabled(FQCN, Level.valueOf(ERROR), null, message, args);
    }

    public void debug(String message, Object...args) {
        this.loggerExt.logIfEnabled(FQCN, Level.valueOf(DEBUG), null, message, args);
    }

    public static void main(String[] args) {
        User user = new User("123",new ArrayList<>());
        Logger logger = new Logger();
        logger.debug("nihao");
    }

}
