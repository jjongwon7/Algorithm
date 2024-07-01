import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp(n, k, w, v);
    }

    public static void dp(int n, int k, int[] w, int[] v) {
        int[][] mem = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i] <= j) { // i번째 물건을 넣을 수 있는 경우
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i - 1][j - w[i]] + v[i]);
                } else {
                    mem[i][j] = mem[i - 1][j];
                }
            }
        }

        System.out.println(mem[n][k]);
    }
}