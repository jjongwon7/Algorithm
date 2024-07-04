import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(n, numbers));

    }

    public static long dp(int n, int[] numbers) {
        long[][] dp = new long[n - 1][21];

        dp[0][numbers[0]] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    int minusResult = j - numbers[i];
                    int plusResult = j + numbers[i];

                    if(minusResult >= 0 && minusResult <= 20) {
                        dp[i][minusResult] += dp[i - 1][j];
                    }

                    if(plusResult >= 0 && plusResult <= 20) {
                        dp[i][plusResult] += dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n - 2][numbers[n - 1]];
    }
}