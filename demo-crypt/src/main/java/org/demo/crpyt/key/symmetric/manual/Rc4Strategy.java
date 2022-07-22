package org.demo.crpyt.key.symmetric.manual;

import lombok.extern.slf4j.Slf4j;
import org.demo.crpyt.constant.AlgorithmConstant;
import org.demo.crpyt.constant.CipherConstant;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.symmetric.SymmetricUtil;
import org.demo.crpyt.key.symmetric.handler.AbstractSymmetricKey;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
@Slf4j
public class Rc4Strategy extends AbstractSymmetricKey {

    private int[] sBox;
    private char[] key;
    private int[] tBox;

    public Rc4Strategy() {
        super(CipherConstant.RC4);
    }

    public Rc4Strategy(String key) {
        //初始化s盒
        this.key = key.toCharArray();
    }

    private void sBoxInit() {
        sBox = new int[256];
        tBox = new int[256];
        for (int i = 0; i < tBox.length; i++) {
            sBox[i] = i;
            tBox[i] = key[i % key.length];
        }
        randomBox();
    }

    private void randomBox() {
        for (int i = 0, j = 0; i < tBox.length; i++) {
            j = (j + tBox[i] + sBox[i]) % 256;
            SymmetricUtil.swap(sBox, i, j);
        }
    }

    @Override
    public KeyEntity encrypt(String data) {
        sBoxInit();
        StringBuilder res = new StringBuilder();
        char[] dataChars = data.toCharArray();
        int si = 0;
        int sj = 0;
        for (int i = 0; i < dataChars.length; i++) {
            //1、打乱顺序
            si = (si + 1) % 256;
            sj = (sj + sBox[si]) % 256;
            SymmetricUtil.swap(sBox, si, sj);
            //异或
            int t = (sBox[si] + sBox[sj]) % 256;
            dataChars[i] ^= sBox[t];
            res.append(dataChars[i]);
        }
        return KeyEntity.KeyEntityBuilder.builder().decodeData(res.toString()).algorithm(getAlgorithm()).build();
    }

    @Override
    public String decrypt(KeyEntity keyEntity) {
        return encrypt(keyEntity.getDecodeData()).getDecodeData();
    }

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.RC4;
    }


}
