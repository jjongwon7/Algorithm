package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_11054 {
    static int[] arr, plus, minus, max;
    public static int DP(int n) {
        int ans = 1;
        Arrays.fill(plus, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && plus[i] < plus[j] + 1) {
                    plus[i] = plus[j] + 1;
                }
            }
        }
        Arrays.fill(minus, 1);
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j] && minus[i] < minus[j] + 1) {
                    minus[i] = minus[j] + 1;
                }
            }
        }
        for (int i = 0; i < n-1; i++) {
            int tmp = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && tmp < minus[j]) {
                    tmp = minus[j];
                }
            }
            ans = Math.max(ans, tmp + plus[i]);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        plus = new int[n];
        minus = new int[n];
        max = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(DP(n));
    }
}
