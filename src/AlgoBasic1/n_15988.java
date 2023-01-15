package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_15988 {
    static long[] dp = new long[1000001];
    public static void DP() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        DP();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            sb.append(dp[n] % 1_000_000_009 + "\n");
        }
        System.out.println(sb);
    }
}
