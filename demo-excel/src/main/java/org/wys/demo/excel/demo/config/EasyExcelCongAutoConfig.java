//package org.wys.demo.excel.demo.config;
//
//import org.wys.demo.excel.demo.annotation.Header;
//import com.sun.tools.javac.util.Pair;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.CollectionUtils;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author wys
// * @date 2021/9/3
// */
//@Slf4j
//public class EasyExcelCongAutoConfig {
//
//    private static int MAX_CAPACITY = 0;
//
//    /**
//     * 动态获取表头信息
//     * @param head
//     * @return
//     */
//    public List<List<String>> autoGetHead(Class<?> head) {
//        List<Pair<Field, Integer>> annotationList = new ArrayList<>();
//        Field[] fields = head.getDeclaredFields();
//        for (Field field : fields) {
//            Header annotation = field.getAnnotation(Header.class);
//            annotationList.add(new Pair<>(field, annotation.score()));
//            MAX_CAPACITY = Math.max(annotation.lastIndex(), MAX_CAPACITY);
//        }
//        List<Pair<Field, Integer>> pairs = annotationList.stream().sorted(Comparator.comparingInt(o -> o.snd)).collect(Collectors.toList());
//        return autoGetHead(pairs);
//    }
//
//    /**
//     * 动态获取表头信息
//     * @param pairs
//     * @return
//     */
//    private List<List<String>> autoGetHead(List<Pair<Field, Integer>> pairs) {
//        if(CollectionUtils.isEmpty(pairs)) {
//            return new ArrayList<>();
//        }
//        List<List<String>> result = new ArrayList<>(MAX_CAPACITY+1);
//        log.info("MAX_CAPACITY ===> {}", MAX_CAPACITY);
//        for (int i = 0; i < MAX_CAPACITY; i++) {
//            result.add(new ArrayList<>());
//        }
//        //排序生成二维数组头
//        for (Pair<Field, Integer> pair : pairs) {
//            Header header = pair.fst.getAnnotation(Header.class);
//            if (header.firstIndex() != 0) {
//                //空填充
//                for (int cnt = 0; cnt < header.firstIndex(); cnt++) {
//                    List<String> list;
//                    list = result.get(cnt);
//                    list.add("");
//                    result.set(cnt, list);
//                }
//            }
//            for (int cnt = header.firstIndex(); cnt < header.lastIndex(); cnt++) {
//                log.info("cnt ===> {}", cnt);
//                List<String> list = result.get(cnt);
//                list.add(header.value());
//                result.set(cnt, list);
//            }
//            if(header.lastIndex() < MAX_CAPACITY) {
//                for (int cnt = header.lastIndex(); cnt < MAX_CAPACITY; cnt++) {
//                    log.info("cnt ===> {}", cnt);
//                    List<String> list = result.get(cnt);
//                    list.add("");
//                    result.set(cnt, list);
//                }
//            }
//            log.info("list====> {}", result);
//            log.info("field name : {} ,   field scope : {}", pair.fst, pair.snd);
//        }
//        return new ArrayList<>();
//    }
//
//}
