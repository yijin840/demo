package org.demo.crpyt.key.asymmetric;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
public class AsymmetricUtil {

    private static final Map<String, String> MAP;
    private static final Map<String, String> GM_MAP;

    static {
        try{
            MAP = new HashMap<>(88);
            GM_MAP = new HashMap<>(1044);
            loadOid();
            loadGmOid();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadOid() {
        System.out.println("aaa");
        String path = Optional.of(AsymmetricUtil.class)
                .map(Class::getClassLoader)
                .map(classLoader -> classLoader.getResource("oid.txt"))
                .map(URL::getPath)
                .orElseThrow(() -> new RuntimeException("file not exist!"));
        try (FileInputStream fis = new FileInputStream(path);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int n;
            StringBuilder stringBuilder = new StringBuilder();
            while ((n = bis.read()) != -1) {
                char ch = (char) n;
                if (ch == '\n') {
                    String[] sps = stringBuilder.toString().split(" ");
                    MAP.put(sps[0] + "_" + sps[2], sps[1]);
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append(ch);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadGmOid() {
        String path = Optional.of(AsymmetricUtil.class)
                .map(Class::getClassLoader)
                .map(classLoader -> classLoader.getResource("gmOid.txt"))
                .map(URL::getPath)
                .orElseThrow(() -> new RuntimeException("file not exist!"));
        try (FileInputStream fis = new FileInputStream(path);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int n;
            StringBuilder stringBuilder = new StringBuilder();
            while ((n = bis.read()) != -1) {
                char ch = (char) n;
                if (ch == '\n') {
                    String[] sps = stringBuilder.toString().split(" ");
                    GM_MAP.put(sps[1].substring(0, sps[1].length() - 1), sps[0]);
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append(ch);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取OID
     *
     * @param algorithm 算法
     * @return oid
     */
    public static String getOid(String algorithm) {
        return MAP.get(algorithm);
    }
    /**
     * 获取OID
     *
     * @param algorithm 算法
     * @return oid
     */
    public static String getGmOid(String algorithm) {
        return GM_MAP.get(algorithm);
    }
}