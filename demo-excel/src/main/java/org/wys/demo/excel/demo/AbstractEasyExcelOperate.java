//package org.wys.demo.excel.demo;
//
//import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
//import com.alibaba.excel.write.handler.AbstractRowWriteHandler;
//import org.wys.demo.excel.demo.annotation.Header;
//import org.wys.demo.excel.demo.config.EasyExcelCongAutoConfig;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.List;
//
//import static org.wys.demo.excel.demo.config.EasyExcelCongAutoConfig.*;
///**
// * @author wys
// * @date 2021/9/3
// */
//@Slf4j
//public abstract class AbstractEasyExcelOperate extends AbstractRowWriteHandler {
//
//    /**
//     * 表头
//     *
//     * @return
//     */
//    protected List<List<String>> head(Class<?> loadClass) throws IllegalAccessException {
//        //自动获取表头
//        EasyExcelCongAutoConfig congAutoConfig = new EasyExcelCongAutoConfig();
//        return congAutoConfig.autoGetHead(loadClass);
//    }
//
//    /**
//     * 数据
//     *
//     * @return
//     */
//    abstract List<Object> data();
//
//    /**
//     * 全局样式
//     *
//     * @return
//     */
//    abstract ExcelWriterSheetBuilder globalStyleStage();
//
//
//}
