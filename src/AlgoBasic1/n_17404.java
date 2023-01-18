package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_17404 {
    private static final int INF = 1000 * 1000 + 1;
    static int[][] cost;
    static int[][] dp;

    public static int DP(int n) {
        int ans = Integer.MAX_VALUE;
        for (int rgb = 0; rgb < 3; rgb++) {
            dp[1][rgb] = cost[1][rgb];
            for (int a = 0; a < 3; a++) {
                if (a != rgb) {
                    dp[1][a] = INF;
                }
            }
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }
            for (int a = 0; a < 3; a++) {
                if (a != rgb) {
                    ans = Math.min(ans, dp[n][a]);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cost = new int[n + 1][3];
        dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(DP(n));
    }
}
