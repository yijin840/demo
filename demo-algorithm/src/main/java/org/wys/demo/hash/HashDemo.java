package org.wys.demo.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ClassName HashDemo
 * Package org.wys.demo.hash
 * Description
 *
 * @author wys
 * @date 2022/6/30 0:43
 */
public class HashDemo {

    public class Codec {
        Map<String, String> oriMap = new HashMap<>();
        Map<String, String> tarMap = new HashMap<>();
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String prefix = "https://acoier.com/tags/";
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            Random r = new Random();
            StringBuilder s = new StringBuilder();
            while(!oriMap.containsKey(s.toString())) {
                s = new StringBuilder();
                s.append(prefix);
                for(int i=0;i<6;i++) {
                    s.append(str.charAt(r.nextInt(str.length())));
                }
                if(oriMap.containsKey(s.toString())) {
                    continue;
                }
                oriMap.put(longUrl, s.toString());
                tarMap.put(s.toString(), longUrl);
            }
            return oriMap.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return tarMap.get(shortUrl);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
