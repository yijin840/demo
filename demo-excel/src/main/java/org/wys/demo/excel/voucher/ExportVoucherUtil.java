//package org.wys.demo.excel.voucher;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.alibaba.excel.write.metadata.fill.FillConfig;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.*;
//import java.math.BigDecimal;
//import java.util.*;
//
///**
// * @author wys
// * @date 2021/9/16
// */
//@Slf4j
//public class ExportVoucherUtil {
//
//    public static void main(String[] args) throws FileNotFoundException {
//        ExportVoucherUtil exportVoucherUtil = new ExportVoucherUtil();
////        exportVoucherUtil.exportExcel();
//    }
//
//    public void exportExcel(ExcelWriter workBook) throws FileNotFoundException {
//        /*
//        {subjectCode}	{subjectName}	{debitAmount}	{creditAmount}
//            合计		{totalDebitAmount}	"{totalCreditAmount}"
//         */
//        WriteSheet writeSheet = EasyExcel.writerSheet().build();
//        FillConfig build = FillConfig.builder().forceNewRow(true).build();
//        //设置需要填充的数据
//        Map<String, Object> map = new HashMap<>();
//        map.put("company", "123");
//        map.put("year", "2020");
//        map.put("month", "09");
//        map.put("totalDebitAmount", "123");
//        map.put("totalCreditAmount", "233");
//        //填充数据
//        workBook.fill(getData(), build, writeSheet);
//        workBook.fill(map, build, writeSheet);
//        workBook.finish();
//    }
//
//    private List<Voucher> getData() {
//        List<Voucher> vouchers = new ArrayList<>();
//        Voucher voucher = new Voucher();
//        voucher.setCreditAmount(BigDecimal.ONE);
//        voucher.setDebitAmount(BigDecimal.ONE);
//        voucher.setSubjectCode("1");
//        voucher.setSubjectName("1");
//        vouchers.add(voucher);
//        Voucher voucher1 = new Voucher();
//        voucher1.setCreditAmount(BigDecimal.ONE);
//        voucher1.setDebitAmount(BigDecimal.ONE);
//        voucher1.setSubjectCode("2");
//        voucher1.setSubjectName("2");
//        vouchers.add(voucher1);
//        return vouchers;
//    }
//
//    @Data
//    static class Voucher {
//        private String subjectCode;
//        private String subjectName;
//        private BigDecimal debitAmount;
//        private BigDecimal creditAmount;
//    }
//
//}
