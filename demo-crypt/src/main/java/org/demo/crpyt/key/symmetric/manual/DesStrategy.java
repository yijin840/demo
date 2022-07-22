package org.demo.crpyt.key.symmetric.manual;


import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.symmetric.handler.AbstractSymmetricKey;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wys
 * @date 2022/07/11
 * @desc
 */
public class DesStrategy extends AbstractSymmetricKey {

    //对齐数组
    private final List<byte[]> align = new ArrayList<>();
    //分段数组
    private final List<byte[]> segment = new ArrayList<>();
    //密钥
    private final String key = "desKey";
    //密钥二进制
    private final List<byte[]> keySegment = new ArrayList<>();
    //密钥分段
    private final List<byte[]> keyAlign = new ArrayList<>();

    @Override
    public KeyEntity encrypt(String data) {
        /*
         * 把信息和密钥转换成二进制64位形式
         * 1、 初始置换，明文进行IP置换
         * 2、 密钥置换 PC-1
         */

        //序列化
        byte[] dataBinary = data.getBytes(StandardCharsets.UTF_8);
        //对齐填充
        alignFillByte(dataBinary, align);
        //转换成二进制分段
        binaryByteArraySegment(align, segment);
        //IP置换
        ipPermutation(getPermutationTable());

        //密钥进行序列化
        byte[] keyBinary = key.getBytes();
        //对齐填充
        alignFillByte(keyBinary, keyAlign);
        //转换成二进制分段
        binaryByteArraySegment(keyAlign, keySegment);
        //获取两把子钥。要用密钥进行获取
        int[][] replacement = selectReplacement();
        //加密数据
        String result = encrypt();
        //返回加密后的结果
        return KeyEntity.KeyEntityBuilder.builder().data(keyBinary).build();
    }

    /**
     * IP置换
     *
     * @return 置换表
     */
    private int[] getPermutationTable() {
        return new int[]{58, 50, 42, 34, 26, 18, 10, 2
                , 60, 52, 44, 36, 28, 20, 12, 4
                , 62, 54, 46, 38, 30, 22, 14, 6
                , 64, 56, 48, 40, 32, 24, 16, 8
                , 57, 49, 41, 33, 25, 17, 9, 1
                , 59, 51, 43, 35, 27, 19, 11, 3
                , 61, 53, 45, 37, 29, 21, 13, 5
                , 63, 55, 47, 39, 31, 23, 15, 7
        };
    }
    private String encrypt() {
        //16次循环
        String res = "";
        int cycleMaxNumber = 16;
        for(int i=0;i<cycleMaxNumber;i++) {

        }

        return res;
    }
    /**
     * 选择置换获取两把子钥
     * @return 两把子钥
     */
    private int[][] selectReplacement() {
        int[][] childTable = new int[2][28];
        childTable[0] = new int[]{
                58, 50, 42, 34, 26, 18, 10,
                60, 52, 44, 36, 28, 20, 12,
                62, 54, 46, 38, 30, 22, 14,
                64, 56, 48, 40, 32, 24, 16
        };
        childTable[1] = new int[]{
                57, 49, 41, 33, 25, 17, 9,
                59, 51, 43, 35, 27, 19, 11,
                61, 53, 45, 37, 29, 21, 13,
                63, 55, 47, 39, 31, 23, 15,
        };
        return childTable;
    }

    /**
     * 将字节数组转换为二进制数组
     * @param segmentList 分段数组
     */
    private void binaryByteArraySegment(List<byte[]> align, List<byte[]> segmentList) {
        for (byte[] b : align) {
            byte[] binaryBit = new byte[64];
            int count = 0;
            for (int i = 0; i < b.length; i++) {
                while (b[i] != 0) {
                    binaryBit[count++] = (byte) (b[i] % 2);
                    b[i] /= 2;
                }
            }
            segmentList.add(binaryBit);
        }
    }


    /**
     * 对字节进行对齐填充
     *
     * @param bytes 字节数组
     * @param alignList 对齐数组
     */
    private void alignFillByte(byte[] bytes, List<byte[]> alignList) {
        /*
         *  1、 64位分块, 每8个字节分割一下
         *  2、 不足的话填充64位
         */
        int cnt = 0;
        int maxBitLen = 8;
        byte[] tempArr = new byte[maxBitLen];
        for (byte aByte : bytes) {
            if ((cnt + 1) % maxBitLen == 0) {
                alignList.add(tempArr);
                tempArr = new byte[maxBitLen];
                cnt = 0;
            } else {
                tempArr[cnt++] = aByte;
            }
        }
    }

    /**
     * ip置换,对分段的二进制数组进行对齐置换
     */
    private void ipPermutation(int[] permutationTable) {
        for (byte[] binaryArr : segment) {
            for (int i = 0; i < permutationTable.length; i++) {
                byte temp = binaryArr[permutationTable[i]];
                binaryArr[permutationTable[i]] = binaryArr[i];
                binaryArr[i] = temp;
            }
        }
    }

    @Override
    public String decrypt(KeyEntity keyEntity) {
        return null;
    }

    @Override
    public String getAlgorithm() {
        return "DES";
    }
}
