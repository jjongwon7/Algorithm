package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_11053 {
    public static int DP(int[] arr) {
        int ans = 1;
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1 ) {
                    dp[i] = dp[j] + 1;
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        int i = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(DP(arr));
    }
}
