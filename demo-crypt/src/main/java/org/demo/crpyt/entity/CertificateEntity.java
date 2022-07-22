package org.demo.crpyt.entity;

import lombok.Data;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.wys.demo.common.annotation.Field;

import java.math.BigInteger;
import java.security.cert.Certificate;
import java.util.Date;

/**
 * @author wys
 * @date 2022/07/20
 * @desc 证书实体类
 */
@Data
public class CertificateEntity {

    @Field("JDK证书")
    private Certificate certificate;

    @Field("序列号")
    private BigInteger serialNumber;

    @Field("签名算法")
    private AlgorithmIdentifier signature;

    @Field("颁发者")
    private X500Name issuer;

    @Field("开始日期")
    private Date startDate;

    @Field("结束日期")
    private Date endDate;

    @Field("使用者")
    private X500Name subject;

    @Field("公钥参数")
    private SubjectPublicKeyInfo subjectPublicKeyInfo;

    @Field("扩展字段")
    private Extensions extensions;

    //TODO
    @Field("我也不太懂")
    private boolean altNamePresentAndCritical;

    @Field("发行人唯一ID")
    private DERBitString issuerUniqueId;

    @Field("使用者唯一ID")
    private DERBitString subjectUniqueId;

}
