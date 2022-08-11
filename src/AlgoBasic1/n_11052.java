package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N+1];
        int[] DP = new int[N+1];
        for(int i=1; i<=N; i++)
            P[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++)
            for(int j=1; j<=i; j++) {
                DP[i] = Math.max(DP[i], DP[i-j] + P[j]);
            }
        System.out.println(DP[N]);

    }
}
