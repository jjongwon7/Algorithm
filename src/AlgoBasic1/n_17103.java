package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_17103 {
    static int[] prime = new int[1000001];
    public static void savePrime() {
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == 0) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        savePrime();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int j = 2; j <= n / 2; j++) {
                if (prime[j] == 0) {
                    if (prime[n-j] == 0) {
                            ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
