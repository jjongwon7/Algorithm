package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1149 {
    static int[][] cost;

    public static int DP(int n) {
        int[][] dp = new int[n + 1][3];
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        cost = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(DP(n));
    }
}
