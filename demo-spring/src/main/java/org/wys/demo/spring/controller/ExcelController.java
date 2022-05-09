package org.wys.demo.spring.controller;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wys
 * @date 2022/5/5
 */
@RestController
@RequestMapping("/excel")
@Slf4j
public class ExcelController {


    @RequestMapping("/write")
    public String excelToData() throws IOException {

        //2、读取excel到内存中
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/excel/socialSecurityFund.xlsx");
            if (inputStream == null) {
                throw new RuntimeException("excel文件不存在");
            }
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("正式");
            if (sheet == null) {
                throw new RuntimeException("excel文件中sheet不存在");
            }
            //3、遍历sheet中的每一行
            String lastOnlyKey = "";
            final int categoriesNum = 5;
            Set<String> categorySet = new HashSet<>();
            for (Row row : sheet) {
                if(row.getRowNum() == 0 || row.getRowNum() == 1 || row.getRowNum() == 2) {
                    continue;
                }
                String city = row.getCell(1).getStringCellValue();
                String country = row.getCell(2).getStringCellValue();
                String region = row.getCell(3).getStringCellValue();
                String onlyKey = city + "_" + country + "_" + region;
                if (!onlyKey.equals(lastOnlyKey)) {
                    //所有分类
                    for (int i = row.getRowNum(); i <= row.getRowNum() + categoriesNum; i++) {
                        categorySet.add(row.getCell(4).getStringCellValue());
                        System.out.print(BigDecimal.valueOf(Double.parseDouble(row.getCell(16).getStringCellValue().substring(0,row.getCell(16).getStringCellValue().indexOf("%")))).divide(BigDecimal.valueOf(100), 4, RoundingMode.DOWN));
//                        for (Cell cell : sheet.getRow(i)) {
//                            //给模型赋值，同时检查缺失哪一个补一个空的类型
//
//                            //
//                            if (cell.getCellType().equals(CellType.STRING)) {
//                                System.out.print(cell.getStringCellValue());
//                            }
//                            if (cell.getCellType().equals(CellType.NUMERIC)) {
//                                System.out.print(BigDecimal.valueOf(cell.getNumericCellValue()).divide(BigDecimal.valueOf(100), 4, RoundingMode.DOWN));
//                            } else {
//                                System.out.print(" ");
//                            }
//                        }
                        System.out.println();
                    }
                }
                lastOnlyKey = onlyKey;
            }
        } catch (IOException e) {
            log.error("read excel error, cause : {}", Throwables.getStackTraceAsString(e));
            throw new RuntimeException("执行出错");
        }
        return "true";
    }

}
