package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[n + 1];
        dp[3] = 1;
        for (int i = 3; i <= n; i++) {
            int a1 = i - 3;
            int a2 = i - 5;
            if (i == 5) dp[i] = 1;
            else if (a2 > 0) { // 3보다 크면
                if (dp[a1] == 0) {
                    if (dp[a2] != 0) {
                        dp[i] = dp[a2] + 1;
                    }
                }

                else if(dp[a2] == 0) {
                    if (dp[a1] != 0) {
                        dp[i] = dp[a1] + 1;
                    }
                }

                else if (dp[a1] > dp[a2]){
                    dp[i] = dp[a2] + 1;
                }

                else{
                    dp[i] = dp[a1] + 1;
                }
            }
        }
        if (dp[n] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}
