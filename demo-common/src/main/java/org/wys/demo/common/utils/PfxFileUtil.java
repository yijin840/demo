package org.wys.demo.common.utils;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.Enumeration;

/**
 * @author wys
 * @date 2022/07/08
 * @desc 没什么用的类，先放着
 */
@SuppressWarnings("unused")
public class PfxFileUtil {

    public static InputStream loadFile(String fileName) {
        try(InputStream in = Files.newInputStream(Paths.get(fileName))) {
            KeyFactory kf = KeyFactory.getInstance("rsa");
            Provider provider = kf.getProvider();
            KeyStore pkcs12 = KeyStore.getInstance("PKCS12");
            pkcs12.load(in, "123456".toCharArray());
            Enumeration<String> enums = pkcs12.aliases();
            while(enums.hasMoreElements()) {
                String s = enums.nextElement();
                System.out.println(s);
            }
            System.out.println(provider);
            X509Certificate x509Certificate = X509Certificate.getInstance(in);
            String sigAlgName = x509Certificate.getSigAlgName();
            System.out.println(sigAlgName);
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException |
                 java.security.cert.CertificateException e) {
            throw new RuntimeException(e);
        }

        return null;
    }



}
