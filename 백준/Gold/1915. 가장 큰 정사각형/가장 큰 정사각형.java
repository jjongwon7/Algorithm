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
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j - 1));
            }
        }

        System.out.println(dp(arr, n, m));
    }
    
    public static int dp(int[][] arr, int n, int m) {
        int ans = Integer.MIN_VALUE;
        int[][] mem = new int[n + 1][m + 1];
        int[] dn = {0, -1, -1};
        int[] dm = {-1, -1, 0};

        for (int cn = 1; cn <= n; cn++) {
            for (int cm = 1; cm <= m; cm++) {
                int minSqrt = Integer.MAX_VALUE;

                for (int k = 0; k < 3; k++) {
                    int pn = cn + dn[k];
                    int pm = cm + dm[k];

                    minSqrt = Math.min(minSqrt, (int) Math.sqrt(mem[pn][pm]));
                }

                if (arr[cn][cm] != 0) {
                    mem[cn][cm] = (int) Math.pow(minSqrt + arr[cn][cm], 2);
                } else {
                    mem[cn][cm] = 0;
                }

                ans = Math.max(mem[cn][cm], ans);
            }
        }

        return ans;
    }
}