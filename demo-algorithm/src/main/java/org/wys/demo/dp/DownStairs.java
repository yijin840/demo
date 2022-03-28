package org.wys.demo.dp;

/**
 * @author wys
 * @date 2022/3/28
 */
public class DownStairs {

    public static void main(String[] args) {
        DownStairs downStairs = new DownStairs();
        downStairs.solution(45);
    }

    public void solution(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        System.out.println(dp[0]);
    }

}
