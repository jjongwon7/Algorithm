package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        long[] dp = new long[n + 1];
        int[] cnt = new int[10];
        dp[1] = 9;
        for (int i = 1; i <= 9; i++) {
            cnt[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int[] tmp = new int[10];
            for (int j = 0; j <= 9; j++) {
                if (cnt[j] > 0) {
                    if (j == 0) {
                        dp[i] = (dp[i] + cnt[0]) % 1_000_000_000;
                        tmp[1] += cnt[0];
                    } else if (j == 9) {
                        dp[i] = (dp[i] + cnt[9]) % 1_000_000_000;
                        tmp[8] += cnt[9];
                    } else {
                        dp[i] = (dp[i] + cnt[j] * 2) % 1_000_000_000;
                        tmp[j - 1] += cnt[j];
                        tmp[j + 1] += cnt[j];
                    }
                }
            }
            for (int j = 0; j <= 9; j++) {
                System.out.print(tmp[j] +" ");
                cnt[j] = tmp[j];
            }
            System.out.println();
        }
        System.out.println(dp[n] % 1_000_000_000);
    }
}
