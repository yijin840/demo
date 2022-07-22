package org.wys.demo.common.exception;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
public class AssertException extends RuntimeException {

    private static final long serialVersionUID = -390240260564403820L;

    public AssertException(String message) {
        super(message);
    }

}
