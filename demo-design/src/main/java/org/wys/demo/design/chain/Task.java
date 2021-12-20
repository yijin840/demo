package org.wys.demo.design.chain;

import lombok.Data;
import org.wys.demo.common.annotation.Field;

/**
 * @author wys
 * @date 2021/12/20
 * 任务
 */
@Data
public class Task {

    @Field("任务描述")
    private String desc;

    @Field(name = "任务类型")
    private String taskType;

    @Field(name = "标志ID")
    private Long signId;
}
