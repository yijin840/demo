package org.demo.crpyt.key.asymmetric.handler;

import org.demo.crpyt.entity.KeyEntity;

/**
 * @author wys
 * @date 2022/07/20
 * @desc 证书抽象类
 */
public interface CertificateHandler {

    /**
     * 签发证书
     *
     * @param entity 签发证书
     * @return 加密实体类
     */
    KeyEntity issuingRootCertificate(KeyEntity entity);


    /**
     * 签发sub证书
     * @param rootEntity 根证书
     * @param subEntity 子证书
     * @return 加密实体类
     */
    KeyEntity issuingSubCertificate(KeyEntity rootEntity, KeyEntity subEntity);


    /**
     * 颁发用户证书
     * @param rootEntity 根证书证书
     * @param userEntity 用户证书
     * @return 加密实体类
     */
    KeyEntity issuingUserCertificate(KeyEntity rootEntity, KeyEntity userEntity);


}
