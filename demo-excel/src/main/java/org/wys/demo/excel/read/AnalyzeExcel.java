//package org.wys.demo.excel.read;
//
//import com.alibaba.excel.EasyExcel;
//import org.wys.demo.annotations.MyField;
//import lombok.Builder;
//import lombok.Data;
//import net.sf.cglib.core.Local;
//import org.springframework.util.StopWatch;
//
//import java.lang.reflect.Field;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.temporal.TemporalAdjusters;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// * @author wys
// * @date 2021/10/9
// */
//public class AnalyzeExcel {
//
//    public static void main(String[] args) throws IllegalAccessException {
////        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
////        // since: 3.0.0-beta1
////        String fileName = "accountMatch.xlsx";
////        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
////        AnalysisAccountDataListen accountDataListen = new AnalysisAccountDataListen();
////        EasyExcel.read(fileName, DemoData.class, accountDataListen).sheet().doRead();
////        System.out.println(accountDataListen.getResult());
//        //获取当前月第一天：
////        String s = "2021年第5期";
////        String lastYearAccountPeriod = Integer.parseInt(s.substring(0, s.indexOf("年"))) - 1 +"第12期";
////        System.out.println(lastYearAccountPeriod);
////        LocalDateTime currentYearStartTime = LocalDateTime.now().withMonth(1).with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
////        LocalDateTime currentYearEndTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).withMonth(12).withHour(23).withMinute(59).withSecond(59);
////        LocalDateTime lastYearStartTime = LocalDateTime.now().plusYears(-1).withMonth(1).with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
////        LocalDateTime lastYearEndTime = LocalDateTime.now().plusYears(-1).with(TemporalAdjusters.lastDayOfMonth()).withMonth(12).withHour(23).withMinute(59).withSecond(59);
////        System.out.println(lastYearEndTime);
////        LocalDateTime start = LocalDateTime.of(2021, 9, 1, 0, 0, 0).with(TemporalAdjusters.firstDayOfMonth());
////        LocalDateTime end = LocalDateTime.of(2021, 9, 1, 23, 59, 59).with(TemporalAdjusters.lastDayOfMonth());
////        ZoneId zoneId = ZoneId.systemDefault();
////        ZonedDateTime zdt = start.atZone(zoneId);
////        Date date = Date.from(zdt.toInstant());
////        System.out.println(end);
////        String accountPeriod = "2021年10期";
////        Integer year = Integer.parseInt(accountPeriod.substring(0, accountPeriod.indexOf("年")));
////        Integer month = Integer.parseInt(accountPeriod.substring(accountPeriod.indexOf("年") + 1, accountPeriod.indexOf("期")));
////        System.out.println(year);
////        System.out.println(month);
//    }
//
//    @Data
//    @Builder
//    static class Test {
//        private String name;
//    }
//}
