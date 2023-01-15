package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_2225 {
    static int[][] DP;
    public static int Combi(int n, int k) {
        if (DP[n][k] != 0) {
            return DP[n][k];
        }
        if (n == 1 || k == 0 || n == k) {
            return 1;
        } else {
            return DP[n][k] = Combi(n - 1, k - 1) + Combi(n - 1, k);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        DP = new int[n + 1][k + 1];
        System.out.println(Combi(n, k));

    }
}
