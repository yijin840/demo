package org.wys.demo.design.chain;

import org.wys.demo.common.annotation.Label;

/**
 * @author wys
 * @date 2021/12/20
 */
public interface AuditStatus {

    @Label(name = "未审核")
    String NO_AUDIT = "NO_AUDIT";

    @Label(name = "审核中")
    String AUDITING = "AUDITING";

    @Label(name = "审核完成")
    String AUDITED = "AUDITED";

    @Label(name = "审核拒绝")
    String AUDIT_FAIL = "AUDIT_FAIL";

}
