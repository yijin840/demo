//package org.wys.demo.spring.controller;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import org.wys.demo.spring.aop.test.ApiTest;
//import org.wys.demo.spring.config.MyConfiguration;
//import org.wys.demo.design.build.Response;
//import org.wys.demo.design.build.ResponseUtil;
//import org.wys.demo.excel.voucher.ExportVoucherUtil;
//import org.wys.demo.po.User;
//import io.swagger.annotations.Api;
//import io.terminus.saas.excel2pdf.util.Excel2PDFUtil;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//@Api(value = "model测试接口", tags = "model接口")
//@Controller
//@AllArgsConstructor
//public class ModelController {
//
//    private final ApiTest apiTest;
//    private final MyConfiguration myConfiguration;
//
//    @GetMapping("/test")
//    public String testConfig() {
//        System.out.println(myConfiguration.getName());
//        return "123";
//    }
//
//    @GetMapping("/success")
//    public Response success() {
//        apiTest.transfer("参数w");
//        return ResponseUtil.success(new User());
//    }
//
//    @GetMapping("/export")
//    public void exportExcel(HttpServletResponse response) throws IOException {
//        ExportVoucherUtil exportVoucherUtil = new ExportVoucherUtil();
//        response.setContentType("application/vnd.ms-excel; charset=utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode("龙哥", "UTF-8") + ".xlsx");
//        //准备模版
//        String templatePath = "excelTemplate/凭证汇总表模版.xlsx";
//        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(templatePath);
//        //创建excel
//        ExcelWriter workBook = EasyExcel.write(response.getOutputStream()).withTemplate(inputStream).build();
//        exportVoucherUtil.exportExcel(workBook);
//    }
//
//    @GetMapping("/print")
//    public void printPdf(HttpServletResponse response) throws IOException {
//        ExportVoucherUtil exportVoucherUtil = new ExportVoucherUtil();
//        response.setContentType("application/pdf; charset=utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setHeader("Content-disposition", "inline;filename=" + java.net.URLEncoder.encode("龙哥", "UTF-8"));
//        //准备模版
//        String templatePath = "excelTemplate/凭证汇总表模版.xlsx";
//        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(templatePath);
//        String s = this.getClass().getClassLoader().getResource("") + templatePath;
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        //创建excel
//        ExcelWriter workBook = EasyExcel.write(outputStream).withTemplate(inputStream).build();
//        exportVoucherUtil.exportExcel(workBook);
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputStream.toByteArray());
//        Excel2PDFUtil.excel2pdf(byteArrayInputStream, response.getOutputStream(), false);
//    }
//}
