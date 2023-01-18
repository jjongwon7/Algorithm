package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_11653 {
    static int[] prime = new int[10000001];
    public static void savePrime() {
        for (int i = 2; i < 10000001; i++) {
            if (prime[i] == 0) {
                for (int j = i + i; j < 10000001; j += i) {
                    prime[j] = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        savePrime();
        for (int i = 2; i <= n; i++) {
            while (prime[i] == 0 && ((n % i) == 0) && (n >= i)) {
                sb.append(i + "\n");
                n /= i;
            }
        }
        System.out.println(sb);
    }
}
