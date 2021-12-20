package org.wys.demo.design.chain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wys
 * @date 2021/12/20
 * 责任链模式的审批流
 */
@Slf4j
public class AuditProcess {

    /**
     * 提交任务，进行审批
     *
     * @param task 任务
     */
    public static void submit(Task task) {
        log.info("审批任务开始执行： {}", task);
        Long signId = task.getSignId();
        String taskType = task.getTaskType();
        AuditNode auditNode = AuditProcess.buildNode(task);
        AuditProcess auditProcess = new AuditProcess();
        auditProcess.chain(auditNode);
    }

    private static AuditNode buildNode(Task task) {
        AuditNode auditNode = new AuditNode();
        auditNode.setAuditorName("张三");
        auditNode.setAuditStatus(AuditStatus.NO_AUDIT);
        auditNode.setCurrentStage(1);
        auditNode.setTotalStage(2);
        auditNode.setTask(task);
        AuditNode nextNode = new AuditNode();
        nextNode.setAuditorName("李四");
        nextNode.setAuditStatus(AuditStatus.NO_AUDIT);
        nextNode.setCurrentStage(2);
        nextNode.setTotalStage(2);
        nextNode.setTask(task);
        auditNode.setNext(nextNode);
        nextNode.setNext(null);
        return auditNode;
    }


    /**
     * 处理逻辑
     */
    public void chain(AuditNode auditNode) {
        auditNode.setAuditStatus(AuditStatus.AUDITING);
        log.info("当前处理人: {}, 任务名称：{}, 处理状态: {}", auditNode.getAuditorName(), auditNode.getTask().getTaskType(), auditNode.getAuditStatus());
        if (auditNode.getCurrentStage() == 1) {
            auditPass(auditNode);
        } else {
            auditFail(auditNode);
        }
    }

    /**
     * 审批成功
     * @param auditNode
     */
    public void auditPass(AuditNode auditNode) {
        auditNode.setAuditStatus(AuditStatus.AUDITED);
        log.info("当前处理人: {}, 任务名称：{}, 处理状态: {}", auditNode.getAuditorName(), auditNode.getTask().getTaskType(), auditNode.getAuditStatus());
        //审核通过丢给下一个审批人
        if (auditNode.getCurrentStage() < auditNode.getTotalStage()) {
            chain(auditNode.getNext());
        }
    }

    /**
     * 审批失败
     * @param auditNode
     */
    public void auditFail(AuditNode auditNode) {
        auditNode.setAuditStatus(AuditStatus.AUDIT_FAIL);
        log.info("当前处理人: {}, 任务名称：{}, 处理状态: {}", auditNode.getAuditorName(), auditNode.getTask().getTaskType(), auditNode.getAuditStatus());
    }
}
