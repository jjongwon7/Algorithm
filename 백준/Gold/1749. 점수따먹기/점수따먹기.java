import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] scores;
    static int[][] cumulativeSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        scores = new int[n + 1][m + 1];
        cumulativeSum = new int[n + 1][m + 1];
        long maxSum = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
                cumulativeSum[i][j] = cumulativeSum[i][j-1] + cumulativeSum[i-1][j] - cumulativeSum[i-1][j-1] + scores[i][j];
            }
        }

        for (int sr = 1; sr <= n; sr++) {
            for (int sc = 1; sc <= m; sc++) {
                for (int er = sr; er <= n; er++) {
                    for (int ec = sc; ec <= m; ec++) {
                        maxSum = Math.max(maxSum,
                                cumulativeSum[er][ec] - cumulativeSum[er][sc - 1] - cumulativeSum[sr - 1][ec]
                                        + cumulativeSum[sr - 1][sc - 1]);
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}