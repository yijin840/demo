package org.wys.demo.spring.transactional;

/**
 * @author wys
 * @date 2022/1/24
 */
public interface TransactionalManager {

    /**
     * 事务提交
     * @return 是否成功
     */
    Boolean commit();

    /**
     * 回滚
     */
    void rockBack();

}
