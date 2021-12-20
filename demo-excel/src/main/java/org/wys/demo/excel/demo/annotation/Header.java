//package org.wys.demo.excel.demo.annotation;
//
//import javax.validation.constraints.NotNull;
//import java.lang.annotation.*;
//
///**
// * 表头，字段，以及涉及范围，还有权重
// * @author wys
// * @date 2021/9/3
// */
//@Target({ElementType.TYPE, ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//public @interface Header {
//
//    /**
//     * 权重
//     * @return
//     */
//    int score() default 0;
//
//    /**
//     * 起始单元格
//     * @return
//     */
//    int firstIndex() default 0;
//
//    /**
//     * 末尾单元格
//     * @return
//     */
//    int lastIndex() default 1;
//
//    /**
//     * 名称
//     * @return
//     */
//    @NotNull  String value();
//
//
//}
