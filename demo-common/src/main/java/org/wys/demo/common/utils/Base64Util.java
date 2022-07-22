package org.wys.demo.common.utils;

import java.util.Arrays;
import java.util.Base64;

/**
 * @author wys
 * @date 2022/07/15
 * @desc
 * 参考来自 @link https://zhuanlan.zhihu.com/p/111700349
 */
public class Base64Util {

    /**
     * 通用编码表
     */
    private static final String CODE_TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    /**
     * 编码块长度
     */
    private static final int CHUNK_SIZE = 6;
    /**
     * 原始块长度
     */
    private static final int ORIGIN_SIZE = 8;
    /**
     * 分隔字符
     */
    private static final char SPILT_CHAR = '=';
    /**
     * 负数字节转为正向值
     */
    private static final int POSITIVE_NUMBER = 256;
    /**
     * 基础字节大小
     */
    private static final int BASE_BIT_SIZE = 24;
    /**
     * 编码
     *
     * @param data 原始字节数组
     * @return 编码后字符串
     */
    public static String encode(byte[] data) {
        //生成二进制块
        data = binaryByteArray(data, ORIGIN_SIZE);
        //填充数组到6的倍数
        data = fillArr(data);
        //编码
        return baseConversion(data);
    }

    /**
     * 解码
     *
     * @param data 编码后的数据
     * @return 解码后的字符串
     */
    public static String decode(byte[] data) {
        //解码,根据表倒推,先映射出索引
        byte[] indexBytes = reverseIndexByte(new String(data));
        //索引二进制
        byte[] binaryBytes = binaryByteArray(indexBytes, CHUNK_SIZE);
        //八位一组进行转换为序列
        byte[] seqBytes = buildSeqBytes(binaryBytes);
        return new String(seqBytes);
    }

    /**
     * 根据二进制块构建序列字节数
     *
     * @param binaryBytes 二进制字节数
     * @return 块状序列字节数
     */
    private static byte[] buildSeqBytes(byte[] binaryBytes) {
        byte[] decimalBytes = new byte[binaryBytes.length / ORIGIN_SIZE];
        int cnt = 0;
        for (int i = 0; i < binaryBytes.length / ORIGIN_SIZE; i++) {
            StringBuilder bs = new StringBuilder();
            //二进制转换为10进制
            for (int j = i * ORIGIN_SIZE; j < (i + 1) * ORIGIN_SIZE; j++) {
                bs.append(binaryBytes[j]);
            }
            decimalBytes[cnt++] = (byte) toDecimal(bs.toString());
        }
        return decimalBytes;
    }

    /**
     * 通过编码字符串逆向生成字节索引数组
     * @param data 编码字符串
     * @return 字节索引数组
     */
    private static byte[] reverseIndexByte(String data) {
        String filterData;
        //过略 = 号
        if (data.indexOf(SPILT_CHAR) != -1) {
            filterData = data.substring(0, data.indexOf(SPILT_CHAR));
        } else {
            filterData = data;
        }
        byte[] reverseBytes = new byte[filterData.length()];
        for (int i = 0; i < filterData.length(); i++) {
            reverseBytes[i] = (byte) CODE_TABLE.indexOf(filterData.charAt(i));
        }
        return reverseBytes;
    }

    /**
     * 将字节数组转换为二进制数组
     *
     * @param data 字节数组
     * @return 二进制数组
     */
    private static byte[] binaryByteArray(byte[] data, int size) {
        byte[] binaryArr = new byte[data.length * size];
        int cnt = 0;
        for (byte b : data) {
            int n = b;
            if (b < 0) {
                n = b + POSITIVE_NUMBER;
            }
            for (int i = 0; i < size; i++) {
                int baseIdx = size - 1 - i + cnt * size;
                binaryArr[baseIdx] = (byte) (n % 2);
                n /= 2;
            }
            cnt++;
        }
        return binaryArr;
    }

    /**
     * 按6的倍数进行填充块数组
     * @param data 二进制字节数组
     * @return 填充后的数据
     */
    private static byte[] fillArr(byte[] data) {
        int rt = data.length % CHUNK_SIZE;
        if (rt == 0) {
            return data;
        }
        int len = data.length;
        data = Arrays.copyOf(data, len + CHUNK_SIZE - rt);
        for (int i = 0; i < CHUNK_SIZE - rt; i++) {
            data[len + i] = (byte) 0;
        }
        return data;
    }

    /**
     * 基础转换，将重新构建的字节二进制数组按6倍块状进行构建编码字符
     * @param data 二进制数组
     * @return 编码后的字符串
     */
    private static String baseConversion(byte[] data) {
        int cnt = 1;
        int count = 0;
        StringBuilder tc = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (byte datum : data) {
            if ((cnt % CHUNK_SIZE) == 0) {
                cnt = 1;
                count++;
                res.append(toTableIdx(tc.append(datum).toString()));
                tc = new StringBuilder();
            } else {
                tc.append(datum);
                cnt++;
            }
        }
        if ((count * CHUNK_SIZE) % BASE_BIT_SIZE != 0) {
            for (int i = 0; i < BASE_BIT_SIZE / ((count * CHUNK_SIZE) % BASE_BIT_SIZE); i++) {
                res.append('=');
            }
        }
        return res.toString();
    }

    /**
     * 返回编码表的索引
     * @param s 二进制字符串序列
     * @return 索引位置
     */
    private static char toTableIdx(String s) {
        return CODE_TABLE.charAt(toDecimal(s));
    }

    /**
     * 二进制转化为十进制
     * @param s 二进制字符串序列
     * @return 十进制数字
     */
    private static int toDecimal(String s) {
        int tenConversion = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            tenConversion += (s.charAt(i) - '0') * (int) Math.pow(2, s.length() - i - 1);
        }
        return tenConversion;
    }

    /**
     * JDK自带的编码类型
     * @param data 原始字节数组
     * @return 编码后的字节数组
     */
    public static byte[] jdkEncode(byte[] data) {
        return Base64.getEncoder().encode(data);
    }

    /**
     * JDK自带的解码工具
     * @param data 编码后的二进制字节数组
     * @return 解码后的二进制字节数组
     */
    public static byte[] jdkDecode(byte[] data) {
        return Base64.getDecoder().decode(data);
    }
}
