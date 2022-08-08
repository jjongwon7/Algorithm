package AlgoBasic1;

import java.io.*;

public class n_1463 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        System.out.println(cal(N));
    }

    static int cal(int N) {
        if(N <= 1)
            return 0;
        if(dp[N] == 0) {
            if ((N % 6) == 0)
                dp[N] = Math.min(cal(N / 3), Math.min(cal(N / 2), cal(N - 1))) + 1;
            else if ((N % 3) == 0)
                dp[N] = Math.min(cal(N / 3), cal(N - 1)) + 1;
            else if ((N % 2) == 0)
                dp[N] = Math.min(cal(N / 2), cal(N - 1)) + 1;
            else
                dp[N] = cal(N - 1) + 1;
        }
        return dp[N];
    }
}
