//package org.wys.demo.utils;
//
///**
// * @author wys
// * @date 2021/9/17
// */
//public class EncodingUtil {
//
//    public static String differentBrownEncoding() {
//            String userAgent = request.getHeader("USER-AGENT");
//            if (StringUtils.contains(userAgent, "MSIE") || StringUtils.contains(userAgent, "Edge")) { // IE浏览器
//                downFileName = URLEncoder.encode(downFileName, "UTF-8");
//            } else if (StringUtils.contains(userAgent, "Firefox")
//                    || StringUtils.contains(userAgent, "Chrome")
//                    || StringUtils.contains(userAgent, "Safari")) { // google,火狐浏览器
//                downFileName = new String(downFileName.getBytes(), "ISO-8859-1");
//            } else {
//                downFileName = URLEncoder.encode(downFileName, "UTF-8"); // 其他浏览器
//            }
//            log.info("downFileName=" + downFileName);
//            response.setHeader("Content-Disposition", "attachment; filename=" + downFileName);
//    }
//
//}
