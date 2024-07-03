import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MOD_NUMBER = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp(n, k);
    }

    public static void dp(int n, int k) {
        int[][] mem = new int[n + 1][k + 1];

        for (int i = 0; i <= k; i++) {
            mem[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                mem[i][j] = (mem[i][j-1] + mem[i-1][j]) % MOD_NUMBER;
            }
        }

        System.out.println(mem[n][k]);
    }
}