package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_1699 {
    static int[] dp;
    public static void DP(int n) {
        dp = new int[100001];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        DP(n);
        System.out.println(dp[n]);
    }
}
