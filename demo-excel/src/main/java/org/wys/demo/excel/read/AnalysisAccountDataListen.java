//package org.wys.demo.excel.read;
//
//import com.alibaba.excel.context.AnalysisContext;
//import com.alibaba.excel.event.AnalysisEventListener;
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
///**
// * @author wys
// * @date 2021/10/9
// */
//@Slf4j
//public class AnalysisAccountDataListen extends AnalysisEventListener<DemoData> {
//
//    private final List<DemoData> demoDataList;
//
//    public AnalysisAccountDataListen() {
//        demoDataList = new ArrayList<>();
//    }
//
//    @Override
//    public void invoke(DemoData data, AnalysisContext context) {
//        log.info("row type ===> {}", context.readRowHolder().getRowType());
//        if (Objects.nonNull(data) && context.readRowHolder().getRowIndex() != 1) {
//            demoDataList.add(data);
//        }
//        log.info("解析数据====>{}", JSON.toJSONString(data));
//    }
//
//    @Override
//    public void doAfterAllAnalysed(AnalysisContext context) {
//        log.info("解析数据完成！");
//    }
//
//    public List<DemoData> getResult() {
//        return Optional.ofNullable(demoDataList).orElse(new ArrayList<>());
//    }
//
//}
