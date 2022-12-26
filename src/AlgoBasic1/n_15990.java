package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_15990 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            int[] DP = new int[N+1];
            DP[3] = 2 % 1_000_000_009;
            DP[4] = 3 % 1_000_000_009;
            for(int j=5; j<=N; j++) {
                DP[j] = (DP[j-1] + DP[j-2]) % 1_000_000_009;
            }
            System.out.println(DP[N]);
        }
    }
    static void cal(int N) {

    }
}
