import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long[][] combi = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            dp(m, n);

            sb.append(combi[m][n]).append("\n");
        }
        System.out.println(sb);
    }

    // nCr = n-1Cr + n-1Cr-1
    public static long dp(int n, int r) {
        if (r == 0 || r == n) {
            return combi[n][r] = 1;
        }

        if (r == 1) {
            return combi[n][r] = n;
        }

        if (combi[n][r] != 0) {
            return combi[n][r];
        }

        return combi[n][r] = dp(n - 1, r) + dp(n - 1, r - 1);
    }
}