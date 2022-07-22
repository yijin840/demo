package org.wys.demo.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.wys.demo.common.exception.AssertException;

import java.math.BigDecimal;

/**
 * @author wys
 * @date 2022/07/12
 * @desc 断言校验工具类
 */
@Slf4j
public class AssertUtil {

    /**
     * 校验为空
     * @param obj object
     */
    public static void notNull(Object obj) {
        if (obj == null) {
            throw new AssertException("object is null");
        }
    }

    /**
     * 校验为空
     * @param obj object
     * @param message message
     */
    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new AssertException(message);
        }
    }

    /**
     * 校验对象是否相同
     * @param origin 原始对象
     * @param target 目标对象
     */
    public static void equalsObject(Object origin, Object target) {
        if(!origin.equals(target)) {
            throw new AssertException("origin object not equals target object");
        }
    }

    /**
     * 逻辑是否一致
     * @param left 左
     * @param right 右
     */
    public static void equalsValue(boolean left, boolean right) {
        if(left != right) {
            throw new AssertException("inconsistent execution results");
        }
    }

    /**
     * 比较int值是否一致
     * @param left 左值
     * @param right 右值
     */
    public static void equalsValue(int left, int right) {
        BigDecimal l = BigDecimal.valueOf(left);
        BigDecimal r = BigDecimal.valueOf(right);
        if(l.compareTo(r) != 0) {
            throw new AssertException("two values are not the same");
        }
    }

    /**
     * 双浮点数， 转化为BigDecimal防止精度损失
     * @param left 左值
     * @param right 右值
     */
    public static void equalsValue(double left, double right) {
        BigDecimal l = BigDecimal.valueOf(left);
        BigDecimal r = BigDecimal.valueOf(right);
        if(l.compareTo(r) != 0) {
            throw new AssertException("two values are not the same");
        }
    }

    /**
     * 浮点数， 转化为BigDecimal防止精度损失
     * @param left 左值
     * @param right 右值
     */
    public static void equalsValue(float left, float right) {
        BigDecimal l = BigDecimal.valueOf(left);
        BigDecimal r = BigDecimal.valueOf(right);
        if(l.compareTo(r) != 0) {
            throw new AssertException("two values are not the same");
        }
    }

}
