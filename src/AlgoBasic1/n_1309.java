package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_1309 {
    static long[][] sum;
    public static long DP(int n) {
        sum[1][0] = sum[1][1] = sum[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            sum[i][0] = (sum[i - 1][0] + sum[i - 1][1] + sum[i - 1][2]) % 9901;
            sum[i][1] = (sum[i - 1][0] + sum[i - 1][2]) % 9901;
            sum[i][2] = (sum[i - 1][0] + sum[i - 1][1]) % 9901;
        }
        return (sum[n][0] + sum[n][1] + sum[n][2]) % 9901;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        sum = new long[n + 1][3];
        System.out.println(DP(n));
    }
}