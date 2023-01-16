package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1932 {
    static int[][] num, max;
    public static int DP(int n) {
        max[0][0] = num[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (j == 0) {
                    max[i][j] = max[i - 1][j];
                } else if (j == num[i].length - 1) {
                    max[i][j] = max[i - 1][j - 1];
                } else {
                    max[i][j] = Math.max(max[i - 1][j - 1], max[i - 1][j]);
                }
                max[i][j] += num[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < num[n-1].length; j++) {
            ans = Math.max(ans, max[n - 1][j]);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n + 1][];
        max = new int[n + 1][];
        for (int i = 0; i < n; i++) {
            num[i] = new int[i+1];
            max[i] = new int[i+1];
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                num[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(DP(n));
    }
}
