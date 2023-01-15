package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_14002 {
    static int[] dp, arr, seq;
    static int ans;
    public static void LIS() {
        ans = 1;
        dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] &&  dp[j] > max) {
                    max = dp[j];
                }
                dp[i] = max + 1;
                ans = Math.max(dp[i], ans);
            }
        }
        seq = new int[ans];
        tracking(arr.length - 1, ans);
    }

    public static void tracking(int i, int max) {
        if (max == 0) {
            return ;
        }
        for (; i >= 0; i--) {
            if (dp[i] == max) {
                if (max == ans) {
                    seq[max - 1] = arr[i];
                }
                else if (arr[i] < seq[max]) {
                    seq[max - 1] = arr[i];
                }
                break;
            }
        }
        tracking(i - 1, max - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n];
        int i = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(stringTokenizer.nextToken());
        }
        LIS();
        sb.append(ans + "\n");
        for (i = 0; i < seq.length; i++) {
            sb.append(seq[i] + " ");
        }
        System.out.println(sb);
    }
}
