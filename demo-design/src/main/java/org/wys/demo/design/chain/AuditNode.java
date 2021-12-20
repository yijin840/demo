package org.wys.demo.design.chain;

import lombok.Data;
import org.wys.demo.common.annotation.Field;

/**
 * @author wys
 * @date 2021/12/20
 * 审批节点
 */
@Data
public class AuditNode {

    @Field(name = "审核员名称")
    private String auditorName;

    @Field(name = "任务")
    private Task task;

    @Field(name = "下个节点")
    private AuditNode next;

    @Field("当前阶段的审核状态")
    private String auditStatus;

    @Field(name = "所有阶段")
    private Integer totalStage;

    @Field(name = "当前阶段")
    private Integer currentStage;

}
