//package org.wys.demo.pdf;
//
//
//import java.io.InputStream;
//
///**
// * @author wys
// * @date 2021/9/17
// */
//public class Excel2PDFUtil {
//    public Excel2PDFUtil() {
//    }
//
//    public static boolean getLicense() {
//        boolean result = false;
//
//        try {
//            InputStream is = io.terminus.saas.excel2pdf.util.Excel2PDFUtil.class.getClassLoader().getResourceAsStream("\\license.xml");
//            License aposeLic = new License();
//            aposeLic.setLicense(is);
//            result = true;
//        } catch (Exception var3) {
//            var3.printStackTrace();
//        }
//
//        return result;
//    }
//
//    public static void excel2pdf(String sourceFilePath, String desFilePathd) {
//        if (getLicense()) {
//            try {
//                Workbook wb = new Workbook(sourceFilePath);
//                FileOutputStream fileOS = new FileOutputStream(desFilePathd);
//                PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
//                pdfSaveOptions.setOnePagePerSheet(true);
//                int[] var10000 = new int[]{3};
//                int[] showSheets = new int[]{0};
//                printSheetPage(wb, showSheets);
//                wb.save(fileOS, pdfSaveOptions);
//                fileOS.flush();
//                fileOS.close();
//                System.out.println("完毕");
//            } catch (Exception var7) {
//                var7.printStackTrace();
//            }
//
//        }
//    }
//
//    public static void excel2pdf(InputStream inputStream, OutputStream outputStream, boolean flag) {
//        if (getLicense()) {
//            try {
//                Workbook wb = new Workbook(inputStream);
//                PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
//                if (flag) {
//                    pdfSaveOptions.setOnePagePerSheet(true);
//                } else {
//                    pdfSaveOptions.setAllColumnsInOnePagePerSheet(true);
//                    pdfSaveOptions.setOnePagePerSheet(false);
//                }
//
//                int[] var10000 = new int[]{3};
//                int[] showSheets = new int[]{0};
//                printSheetPage(wb, showSheets);
//                wb.save(outputStream, pdfSaveOptions);
//                outputStream.flush();
//                outputStream.close();
//            } catch (Exception var7) {
//                var7.printStackTrace();
//            }
//
//        }
//    }
//
//    public static void autoDraw(Workbook wb, int[] page) {
//        if (null != page && page.length > 0) {
//            for(int i = 0; i < page.length; ++i) {
//                wb.getWorksheets().get(i).getHorizontalPageBreaks().clear();
//                wb.getWorksheets().get(i).getVerticalPageBreaks().clear();
//            }
//        }
//
//    }
//
//    public static void printSheetPage(Workbook wb, int[] page) {
//        int i;
//        for(i = 1; i < wb.getWorksheets().getCount(); ++i) {
//            wb.getWorksheets().get(i).setVisible(false);
//        }
//
//        if (null != page && page.length != 0) {
//            for(i = 0; i < page.length; ++i) {
//                wb.getWorksheets().get(i).setVisible(true);
//            }
//        } else {
//            wb.getWorksheets().get(0).setVisible(true);
//        }
//
//    }
//}
