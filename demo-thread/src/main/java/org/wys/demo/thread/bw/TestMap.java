package org.wys.demo.thread.bw;

import java.util.Map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
public class TestMap<K, V> implements Map<K, V> {

    int capacity;
    int size;
    Node<K,V>[] entries;

    static class Node<K,V> {
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    public TestMap(int capacity) {
        this.capacity = capacity;
        entries = new Node[capacity];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }
    @Override
    public V get(Object key) {
        if(key == null) {
            throw new NullPointerException();
        }
        if(entries[key.hashCode() % capacity] == null) {
            return null;
        }
        return entries[key.hashCode() % capacity].getValue();
    }
    @Override
    public V put(K key, V value) {
        int index = ((K)key).hashCode() % entries.length;
        Node<K,V> entry = new Node<>(key,value);
        entry.setKey(key);
        entry.setValue(value);
        size++;
        entries[index] = entry;
        return entry.getValue();
    }
    @Override
    public V remove(Object key) {
        if(entries[key.hashCode() % capacity] == null) {
            return null;
        } else {
            Node<K,V> entry = entries[key.hashCode() % capacity];
            entries[key.hashCode() % capacity] = null;
            size--;
            return entry.getValue();
        }
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public boolean containsKey(Object key) {
        return false;
    }
    @Override
    public boolean containsValue(Object value) {
        return false;
    }
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
    }
    @Override
    public void clear() {
    }
    @Override
    public Set<K> keySet() {
        return null;
    }
    @Override
    public Collection<V> values() {
        return null;
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public static void main(String[] args) {
        TestMap<String, String> testMap = new TestMap<>(10);
        testMap.put("1", "1");
        testMap.put("2", "2");
        System.out.println(testMap.get("1"));
        System.out.println(testMap.size());
        testMap.remove("1");
        System.out.println(testMap.get("1"));
        System.out.println(testMap.size());
    }
}
