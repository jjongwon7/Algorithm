import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] method;
    static int[] dm = {-1, 0, 1, 0};
    static int[] dn = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        method = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(method[i], -1);
        }

        int ans = dfs(0, 0);

        System.out.println(ans);
    }

    public static int dfs(int curN, int curM) {
        if (curN == n - 1 && curM == m - 1) {
            return 1;
        }

        // 이미 갔던 길이라면 더 이상 진행하지 않음
        if (method[curM][curN] != -1) {
            return method[curM][curN];
        }

        method[curM][curN] = 0;

        for (int i = 0; i < 4; i++) {
            int nextN = curN + dn[i];
            int nextM = curM + dm[i];

            if (nextN >= 0 && nextM >= 0 && nextN < n && nextM < m) {
                // 작은 경우에만 이동
                if (arr[nextM][nextN] < arr[curM][curN]) {
                    method[curM][curN] += dfs(nextN, nextM);
                }
            }
        }

        return method[curM][curN];
    }
}