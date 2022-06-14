package org.wys.demo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName LRUCache
 * Package org.wys.demo.lru
 * Description
 *
 * @author wys
 * @date 2022/6/14 10:21
 */
class LRUCache {

    private int capacity;
    private Map<Integer,Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Integer value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        map.put(key,value);
        if(map.size()>capacity){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */