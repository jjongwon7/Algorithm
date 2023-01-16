package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n_11057 {
    public static long DP(int n) {
        long cnt[][] = new long[n][10];
        long sum = 0;
        Arrays.fill(cnt[0], 1);
        for (int i = 1; i < n; i++) {
            cnt[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                cnt[i][j] = (cnt[i][j-1] + cnt[i-1][j]) % 10007;
            }
        }
        for (int i = 0; i < 10; i++) {
            sum = (sum + cnt[n - 1][i]) % 10007;
        }
        return sum % 10007;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(DP(n));
    }
}
