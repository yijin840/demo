package org.wys.demo.hash;

import java.util.*;

/**
 * @author wys
 * @date 2022/3/30
 */
public class ConsistencyHash {

    public static void main(String[] args) {
        int k = 13;
        int[] arrival = new int[]{1, 3, 5, 6, 7, 8, 13, 15, 18, 20, 21, 22, 23, 26, 28, 33, 35, 38, 39, 43, 46, 47, 49, 51, 55, 56, 58, 59, 60, 62, 67, 69, 72, 73, 75, 79, 80, 81, 82, 83, 84, 85, 86, 87, 89, 90, 92, 93, 96};
        int[] load = new int[]{13, 12, 39, 5, 40, 43, 44, 18, 13, 19, 9, 42, 34, 25, 1, 13, 44, 23, 46, 3, 30, 1, 48, 47, 11, 12, 5, 46, 2, 41, 2, 4, 49, 10, 36, 36, 21, 18, 46, 20, 31, 41, 18, 15, 17, 7, 22, 40, 11};
        //13
        //' +
        //  '[1,3,5,6,7,8,13,15,18,20,21,22,23,26,28,33,35,38,39,43,46,47,49,51,55,56,58,59,60,62,67,69,72,73,75,79,80,81,82,83,84,85,86,87,89,90,92,93,96]
        //' +
        //  '[13,12,39,5,40,43,44,18,13,19,9,42,34,25,1,13,44,23,46,3,30,1,48,47,11,12,5,46,2,41,2,4,49,10,36,36,21,18,46,20,31,41,18,15,17,7,22,40,11]
        ConsistencyHash hash = new ConsistencyHash();
        List<Integer> list = hash.busiestServers(k, arrival, load);
        list.forEach(System.out::println);
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Map<Integer, Integer> vis = new HashMap<>(k);
        Map<Integer, Integer> visNum = new HashMap<>(k);
        List<Integer> res = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < arrival.length; i++) {
            //当前时间
            int time = arrival[i];
            last = arrival[i];
            //处理所有任务
            for (Integer cur : vis.keySet()) {
                int process = vis.getOrDefault(cur, 0) - time;
                if (process < 0) {
                    process = 0;
                }
                vis.put(cur, process);
            }
            int cur = -1;
            //空闲
            for (int j = i % k; j < k; j++) {
                if (vis.getOrDefault(j, 0) == 0) {
                    cur = j;
                    break;
                }
            }
            if (cur == -1 && i % k != 0) {
                for (int j = 0; j < k - (i % k); j++) {
                    if (vis.getOrDefault(j, 0) == 0) {
                        cur = j;
                        break;
                    }
                }
            }
            //当前空闲
            if (cur != -1) {
                vis.put(cur, load[i]);
                visNum.put(cur, visNum.getOrDefault(cur, 0) + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(visNum.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        for (int i = entryList.size() - 1; i >= 0; i--) {
            if (i == entryList.size() - 1 || entryList.get(i).getValue().compareTo(entryList.get(entryList.size() - 1).getValue()) == 0) {
                res.add(entryList.get(i).getKey());
            }
        }
        return res;
    }

}

