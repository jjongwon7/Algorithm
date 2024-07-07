import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] costs = new int[n + 1][m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp(n, m, costs);
    }

    public static void dp(int n, int m, int[][] costs) {
        final int MAX_VALUE = 100000;
        int[][][] mem = new int[3][n + 1][m];
        int[] dm = {-1, 0, 1};

        for (int cn = 1; cn <= n; cn++) {
            for (int cm = 0; cm < m; cm++) {
                for (int cd = 0; cd < 3; cd++) {
                    int pn = cn - 1;
                    int pm = cm - dm[cd];

                    if (pm < 0 || pm >= m) {
                        mem[cd][cn][cm] = MAX_VALUE;
                        continue;
                    }

                    int minCost = MAX_VALUE;

                    for (int pd = 0; pd < 3; pd++) {
                        if (pd != cd) {
                            minCost = Math.min(minCost, mem[pd][pn][pm] + costs[cn][cm]);
                        }
                    }

                    mem[cd][cn][cm] = minCost;
                }
            }
        }

        int ans = MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                if (mem[j][n][i] != 0) {
                    ans = Math.min(mem[j][n][i], ans);
                }
            }
        }

        System.out.println(ans);
    }

}