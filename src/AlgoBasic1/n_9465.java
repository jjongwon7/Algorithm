package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_9465 {
    static int[][] score, max;

    public static int DP(int n) {
        max[0][0] = score[0][0];
        max[1][0] = score[1][0];
        if(n > 1) {
            max[0][1] = score[0][1] + max[1][0];
            max[1][1] = score[1][1] + max[0][0];
            for (int i = 2; i < n; i++) {
                max[0][i] = Math.max(max[1][i - 1], (Math.max(max[0][i - 2], max[1][i - 2]))) + score[0][i];
                max[1][i] = Math.max(max[0][i - 1], (Math.max(max[0][i - 2], max[1][i - 2]))) + score[1][i];
            }
        }
        return Math.max(max[0][n-1], max[1][n-1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bf.readLine());
            score = new int[2][n];
            max = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(DP(n)).append("\n");
        }
        System.out.println(sb);
    }
}