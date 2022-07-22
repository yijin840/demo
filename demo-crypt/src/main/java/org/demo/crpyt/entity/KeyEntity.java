package org.demo.crpyt.entity;

import lombok.Data;
import org.demo.crpyt.constant.AlgorithmConstant;
import org.demo.crpyt.constant.SignatureConstant;
import org.wys.demo.common.annotation.DictClass;
import org.wys.demo.common.annotation.Field;

import java.io.Serializable;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
@Data
public class KeyEntity implements Serializable {

    private static final long serialVersionUID = 5421570265027998633L;

    @Field("数据")
    private byte[] data;

    @Field("密钥")
    private Key key;

    @Field("算法名称")
    @DictClass(clazz = AlgorithmConstant.class)
    private String algorithm;

    @Field("原数据对象")
    private Object origin;

    @Field("解码数据")
    private String decodeData;

    @Field("公钥")
    private PublicKey publicKey;

    @Field("私钥")
    private PrivateKey privateKey;

    @Field("摘要消息")
    private byte[] summaryMessage;

    @Field("签名算法")
    @DictClass(clazz = SignatureConstant.class)
    private String signAlgorithm;

    @Field("证书")
    private CertificateEntity certificate;
    /**
     * @author wys
     * @date 2022/07/12
     * @desc
     */
    public static class KeyEntityBuilder implements Serializable {
        private final KeyEntity symmetric = new KeyEntity();
        private static final long serialVersionUID = -1880324293633009912L;

        public static KeyEntityBuilder builder() {
            return new KeyEntityBuilder();
        }

        public KeyEntityBuilder data(byte[] data) {
            symmetric.setData(data);
            return this;
        }

        public KeyEntityBuilder key(Key key) {
            symmetric.setKey(key);
            return this;
        }

        public KeyEntity build() {
            return symmetric;
        }

        public KeyEntityBuilder algorithm(String algorithm) {
            symmetric.setAlgorithm(algorithm);
            return this;
        }
        public KeyEntityBuilder decodeData(String decodeData) {
            symmetric.setDecodeData(decodeData);
            return this;
        }

        public KeyEntityBuilder publicKey(PublicKey publicKey) {
            symmetric.setPublicKey(publicKey);
            return this;
        }

        public KeyEntityBuilder privateKey(PrivateKey privateKey) {
            symmetric.setPrivateKey(privateKey);
            return this;
        }

    }

}
