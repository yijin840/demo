package org.wys.demo.spring.transactional;

import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2022/1/24
 */
@Component
public class CommonTransactional implements TransactionalManager {

    @Override
    public Boolean commit() {
        return null;
    }

    @Override
    public void rockBack() {
        
    }
}
