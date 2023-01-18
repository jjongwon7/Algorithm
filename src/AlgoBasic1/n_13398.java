package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_13398 {
    static int[] arr;

    public static int DP(int n) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                int tmp = sum;
                for (int j = i + 1; j < n; j++) {
                    if (tmp + arr[j] < 0) {
                        break;
                    }
                    tmp += arr[j];
                    ans = Math.max(ans, tmp);
                }
                if (sum == 0) {
                    ans = Math.max(ans, arr[i]);
                }
            }
            if (sum + arr[i] < 0) {
                sum = 0;
            } else {
                sum += arr[i];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(DP(n));
    }
}
