package org.wys.demo.db.mysql;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wys
 * @date 2021/9/8
 */
public class MysqlDemo {

    public static void main(String[] args) {
        String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        char[] chArr = order.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<chArr.length;i++) {
            map.put(chArr[i], i);
        }
        for(String s : words) {
            for(int i = 0;i<s.length();i++) {
                if(map.get(s.charAt(i)) > map.get(s.charAt(i+1))) {
                    System.out.println(s.charAt(i) + " : " + s.charAt(i+1));
                    return false;
                }
            }
            break;
        }
        return true;
    }




}
