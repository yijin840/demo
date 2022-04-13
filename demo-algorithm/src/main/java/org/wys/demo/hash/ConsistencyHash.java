package org.wys.demo.hash;

import java.util.*;

/**
 * @author wys
 * @date 2022/3/30
 */
public class ConsistencyHash {

    public static void main(String[] args) {
        int k = 3;
        int[] arrival = new int[]{1, 2, 3, 4, 8, 9, 10};
        int[] load = new int[]{5, 2, 10, 3, 1, 2, 2};
        ConsistencyHash hash = new ConsistencyHash();
        List<Integer> list = hash.busiestServers(k, arrival, load);
        list.forEach(System.out::println);
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] visNum = new int[k];
        int[] vis = new int[k];
        int[] visTime = new int[k];
        int maxNum = -1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arrival.length; i++) {
            int j = i % k;
            int p = 0;
            int left = -1;
            int right = -1;
            while (j < k || p < i % k) {
                if (j < k && arrival[i] - visTime[j] >= vis[j]) {
                    right = j;
                    break;
                }
                if (p < i % k && arrival[i] - visTime[p] >= vis[p] && left == -1) {
                    left = p;
                }
                if(left != -1 && j >= k) {
                    break;
                }
                j++;
                p++;
            }
            if (left != -1 || right != -1) {
                int cur = right == -1 ? left : right;
                visTime[cur] = arrival[i];
                vis[cur] = load[i];
                visNum[cur]++;
                maxNum = Math.max(visNum[cur], maxNum);
            }
        }
        for (int j = visNum.length - 1; j >= 0; j--) {
            if (visNum[j] == maxNum) {
                res.add(j);
            }
        }
        return res;
    }
}

