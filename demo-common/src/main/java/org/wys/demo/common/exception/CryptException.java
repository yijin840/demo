package org.wys.demo.common.exception;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
public class CryptException extends RuntimeException {

    private static final long serialVersionUID = -351618688710191309L;

    public CryptException(String message) {
        super(message);
    }

    public CryptException(Throwable e) {
        super(e);
    }

}
