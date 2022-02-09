package org.wys.demo.spring.transactional;

import lombok.Data;

/**
 * @author wys
 * @date 2022/1/24
 */
@Data
public class TransactionalDefinition {
    /**
     * 级别
     */
    private String level;

    /**
     * 是否只读
     */
    private Boolean isReadOnly;

}
