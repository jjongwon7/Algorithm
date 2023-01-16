package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_11055 {
    static int[] arr;
    public static int DP(int n) {
        int[] max = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            max[i] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && max[i] < max[j] + arr[i]) {
                    max[i] = max[j] + arr[i];
                }
            }
            ans = Math.max(ans, max[i]);
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
