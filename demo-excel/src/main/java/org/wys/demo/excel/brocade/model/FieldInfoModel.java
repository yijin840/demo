package org.wys.demo.excel.brocade.model;

import lombok.Data;

/**
 * @author wys
 * @date 2021/12/27
 */
@Data
public class FieldInfoModel {

    private String fieldName;

    private Boolean isHandler;

    private Object value;

    private String parseResult;

}
