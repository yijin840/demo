package org.wys.demo.test;

import io.swagger.models.auth.In;

import java.util.*;
import java.util.stream.Collectors;

public class SetTest {

    public static void main(String[] args) {
        System.out.println(lexicalOrder(49999));
    }


    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            dfs(n,i, res);
        }
        return res;
    }

    public static void dfs(int n, int cnt, List<Integer> res) {
        if(res.contains(cnt)) {
            return;
        }
        res.add(cnt);
        for(int i=0;i<=9;i++) {
            if(cnt *10 + i > n) {
                return;
            } else {
                dfs(n, cnt * 10 + i, res);
            }
        }
    }
}
