package org.wys.demo.design.chain;

/**
 * @author wys
 * @date 2021/12/20
 */
public class AuditApplication {
    /**
     * 用户端
     * 提交审核
     * @param args
     */
    public static void main(String[] args) {
        Task task = new Task();
        //任务类型
        task.setTaskType(TaskTypeDict.ASK_FOR_LEAVE);
        //任务标志ID ， 任务类型和标志ID确定唯一一条流程
        task.setSignId(1L);
        //任务描述
        task.setDesc("这是一个请假理由！");
        //提交任务
        AuditProcess.submit(task);
    }
}
