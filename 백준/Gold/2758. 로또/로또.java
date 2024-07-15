import java.util.*;
import java.io.*;

public class Main {

    static long[][] mem = new long[11][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp(10, 2000);

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(mem[n][m]);
        }
    }

    public static void dp(int n, int m) {
        Arrays.fill(mem[0], 1);
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mem[i][j] = mem[i - 1][j / 2] + mem[i][j - 1];
            }
        }
    }
}