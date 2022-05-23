package org.wys.demo.map;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName BfsMap
 * Package org.wys.demo.map
 * Description
 *
 * @author wys
 * @date 2022/5/23 23:21
 */
public class BfsMap {

    private static final int INF = Integer.MAX_VALUE;
    private static int nv,ne;
    private static boolean[] vis;
    private static int[][] map;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nv = scanner.nextInt();
        ne = scanner.nextInt();
        map = new int[nv][nv];
        vis = new boolean[nv];
        //所有路都设置不能通行
        for(int i=0;i<nv;i++) {
            vis[i] = false;
            for(int j=0;j<nv;j++) {
                map[i][j] = map[j][i] = INF;
            }
        }
        for(int i=0;i<ne;i++) {
            int a,b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            map[a][b] = map[b][a] = 1;
        }
        //8 6
        //0 7
        //0 1
        //2 0
        //4 1
        //2 4
        //3 5
        for(int i=0;i<nv;i++) {
            if(!vis[i]) {
                bfs(i);
            }
        }

    }
    private static void bfs(int n) {
        Deque<Integer> deque = new LinkedList<>();
        vis[n] = true;
        //尾进头拿
        deque.addLast(n);
        while(!deque.isEmpty()) {
            int m = deque.pollFirst();
            System.out.print(m + " ");
            for(int i=0;i<nv;i++) {
                if(!vis[i] && map[m][i]!=INF) {
                    deque.addLast(i);
                    vis[i] = true;
                }
            }
        }
    }
}
