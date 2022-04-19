package org.wys.demo.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Encrypter {

    private String[] values = new String[26];
    private Map<String, Integer> map = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < values.length; i++) {
            this.values[keys[i] - 'a'] = values[i];
        }
        for (int i = 0; i < dictionary.length; i++) {
            String s = encrypt(dictionary[i]);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            s.append(values[word1.charAt(i) - 'a']);
        }
        return s.toString();
    }

    public int decrypt(String word2) {
        return map.getOrDefault(word2, 0);
    }

}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */