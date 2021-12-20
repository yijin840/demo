//package org.wys.demo.excel.demo;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.metadata.Head;
//import com.alibaba.excel.util.StyleUtil;
//import com.alibaba.excel.write.handler.AbstractRowWriteHandler;
//import com.alibaba.excel.write.merge.AbstractMergeStrategy;
//import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
//import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
//import com.alibaba.excel.write.metadata.style.WriteCellStyle;
//import com.alibaba.excel.write.metadata.style.WriteFont;
//import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.ss.util.CellUtil;
//
//import java.io.File;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.*;
//
///**
// * @author wys
// * @date 2021/9/3
// */
//@Slf4j
//public class GenerateExcelDemo {
//    public static void main(String[] args) throws URISyntaxException {
//        excelWrite();
//    }
//
//    public static void excelWrite() throws URISyntaxException {
//        String fileName = System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        EasyExcel.write(fileName).head(head()).sheet("模板")
////                .registerWriteHandler(new MyMergeStrategy())//自定义合并 单元格
//                .registerWriteHandler(new StyleWriteHandler())
//                .registerWriteHandler(CellStyleStrategy.StyleStrategy())
//                .doWrite(null);
//    }
//    private static List<List<String>> data() {ls
//        List<UserTemplate> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            UserTemplate data = new UserTemplate();
//            data.setString("字符串" + i);
//            data.setDate(new Date());
//            data.setDoubleData(0.56);
//            list.add(data);
//        }
//        return null;
//    }
//
//    /**
//     * 创建表头
//     *
//     * @return
//     */
//    private static List<List<String>> head() throws URISyntaxException {
//        SimpleEasyExcelOperate simpleEasyExcelOperate = new SimpleEasyExcelOperate();
//        final List<List<List<String>>> headers = new ArrayList<>();
//        //默认使用的类加载器
//        ClassLoader classLoader = SimpleEasyExcelOperate.class.getClassLoader();
//        //扫描所有包下的java类
//        String packagePath = "org.wys.demo.excel.demo.model";
//        URL url = classLoader.getResource(packagePath.replace(".", "/"));
//        assert url != null;
//        URI uri = url.toURI();
//        File file = new File(uri);
//        Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(item->{
//            try {
//                Class<?> loadClass = classLoader.loadClass(packagePath+"."+item.getName().substring(0,item.getName().indexOf(".")));
//                headers.add(simpleEasyExcelOperate.head(loadClass));
//            } catch (ClassNotFoundException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        });
//        log.info("url ==> {}", url);
//        return headers.get(0);
//    }
//
//    public static List<List<String>> excelHead() {
//        List<List<String>> headList = new ArrayList<>();
//        headList.add(new ArrayList() {
//            {
//                add("利润表");
//                add("yyyy年mm月");
//            }
//        });
//        headList.add(new ArrayList() {{
//            add("利润表");
//            add("yyyy年mm月");
//        }});
//        headList.add(new ArrayList() {{
//            add("利润表");
//            add("yyyy年mm月");
//        }});
//        headList.add(new ArrayList() {{
//            add("利润表");
//            add("yyyy年mm月");
//        }});
//        headList.add(new ArrayList() {{
//            add("利润表");
//            add("yyyy年mm月");
//        }});
//        headList.add(new ArrayList() {{
//            add("利润表");
//            add("yyyy年mm月");
//        }});
//        headList.add(new ArrayList() {{
//            add("利润表");
//            add("");
//        }});
//        return headList;
//    }
//
//
//    public static class MyMergeStrategy extends AbstractMergeStrategy {
//        //合并坐标集合
//        private final List<CellRangeAddress> cellRangeAddress;
//
//        //构造
//        public MyMergeStrategy() {
//            List<CellRangeAddress> list = new ArrayList<>();
//            //合并 单元格坐标
//            CellRangeAddress item1 = new CellRangeAddress(0, 0, 2, 5);
//            CellRangeAddress item2 = new CellRangeAddress(2, 2, 2, 5);
//            CellRangeAddress item3 = new CellRangeAddress(3, 3, 0, 1);
//            list.add(item1);
//            list.add(item2);
//            list.add(item3);
//            this.cellRangeAddress = list;
//        }
//
//        /**
//         * merge
//         *
//         * @param sheet
//         * @param cell
//         * @param head
//         * @param relativeRowIndex
//         */
//        @Override
//        protected void merge(Sheet sheet, Cell cell, Head head, Integer relativeRowIndex) {
//            //合并单元格
//            /**
//             *  ****加个判断:if (cell.getRowIndex() == 1 && cell.getColumnIndex() == 0) {}****
//             * 保证每个cell被合并一次，如果不加上面的判断，因为是一个cell一个cell操作的，
//             * 例如合并A2:A3,当cell为A2时，合并A2,A3，但是当cell为A3时，又是合并A2,A3，
//             * 但此时A2,A3已经是合并的单元格了
//             */
//            if (CollectionUtils.isNotEmpty(cellRangeAddress)) {
//                if (cell.getRowIndex() == 1 && cell.getColumnIndex() == 0) {
//                    for (CellRangeAddress item : cellRangeAddress) {
//                        sheet.addMergedRegionUnsafe(item);
//                    }
//                }
//            }
//        }
//    }
//
//
//    public static class CellStyleStrategy {
//
//        /**
//         * 设置表头  和内容样式
//         *
//         * @return
//         */
//        public static HorizontalCellStyleStrategy StyleStrategy() {
//            // 表头样式策略
//            WriteCellStyle headWriteCellStyle = new WriteCellStyle();
//            //设置表头居中对齐
//            headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
//            //表头前景色
//            headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
//            WriteFont headWriteFont = new WriteFont();
//            headWriteFont.setBold(true);
//            headWriteFont.setFontName("Helvetica");
//            headWriteFont.setFontHeightInPoints((short) 20);
//            headWriteCellStyle.setWriteFont(headWriteFont);
//
//            //2 内容样式策略
//            WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
//            WriteFont contentWriteFont = new WriteFont();
//            //内容字体大小
//            contentWriteFont.setFontName("宋体");
//            contentWriteFont.setFontHeightInPoints((short) 10);
//            contentWriteCellStyle.setWriteFont(contentWriteFont);
//            //设置自动换行
//            contentWriteCellStyle.setWrapped(true);
//            //设置垂直居中
//            contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//            // 头默认了 FillPatternType所以可以不指定。
//            //  contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
//            //设置水平居中
//            contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
//
//            //设置边框样式
//            contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
//            contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
//            contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
//            contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
//
//            return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
//        }
//    }
//
//    /**
//     * 自定义拦截器.新增注释,第一行头加批注
//     *
//     * @author Jiaju Zhuang
//     */
//    public static class StyleWriteHandler extends AbstractRowWriteHandler {
//
//        @Override
//        public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
//                                    Integer relativeRowIndex, Boolean isHead) {
//            if (isHead) {
//                Iterator<Cell> iterator = row.cellIterator();
//                while(iterator.hasNext()) {
//                    Cell cell = iterator.next();
//                    int i = cell.getColumnIndex();
//                    // 根据单元格获取workbook
//                    if (0 == cell.getRowIndex()) {
//                        setRowStyleByIndex(i, cell,writeSheetHolder);
//                    }
//                    if (1 == cell.getRowIndex()) {
//                        setRowStyleByIndex(i, cell,writeSheetHolder);
//                    }
//                }
//            }
//        }
//
//        private void setRowStyleByIndex(int cur, Cell cell,WriteSheetHolder writeSheetHolder) {
//            // 根据单元格获取workbook
//            Workbook workbook = cell.getSheet().getWorkbook();
//            //设置行高
//            writeSheetHolder.getSheet().setColumnWidth(cur, (short) (13.18 * 256));
//            // 单元格策略
//            WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
//            // 设置背景颜色白色
//            contentWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
//            WriteFont contentWriteFont = new WriteFont();
//            //内容字体大小
//            contentWriteFont.setFontName("宋体");
//            contentWriteFont.setBold(true);
//            contentWriteFont.setFontHeightInPoints((short) 30);
//            contentWriteCellStyle.setWriteFont(contentWriteFont);
//            contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
//            contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
//            contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
//            contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
//            CellStyle cellStyle = StyleUtil.buildHeadCellStyle(workbook, contentWriteCellStyle);
//            //设置当前行第i列的样式
//            CellUtil.getCell(cell.getRow(), cur).setCellStyle(cellStyle);
//        }
//    }
//}
