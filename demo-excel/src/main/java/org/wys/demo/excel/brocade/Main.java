package org.wys.demo.excel.brocade;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wys
 * @date 2021/12/27
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            URL url = new URL("http://118.31.251.1:8090/upload/2021/12/test1-c1ef5d1ea3534444a62680f253920f36.xlsx");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(inputStream == null) {
            return;
        }
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet) {
                for(Cell cell : row) {
                    log.info("cell => {}", cell);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
