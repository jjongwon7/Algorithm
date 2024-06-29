import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] cumulativeSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        cumulativeSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initCumulativeSum();

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            sb.append(calcCumulativeSum(sr, sc, er, ec)).append("\n");
        }

        System.out.println(sb);
    }

    public static void initCumulativeSum() {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                cumulativeSum[i][j] = cumulativeSum[i - 1][j] + cumulativeSum[i][j - 1] - cumulativeSum[i - 1][j - 1] + map[i][j];
            }
        }
    }

    public static int calcCumulativeSum(int sr, int sc, int er, int ec) {
        return cumulativeSum[er][ec] - cumulativeSum[sr - 1][ec] - cumulativeSum[er][sc - 1] + cumulativeSum[sr - 1][sc - 1];
    }
}