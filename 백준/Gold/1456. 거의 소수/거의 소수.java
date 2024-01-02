import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        prime = new boolean[10_000_001];

        Arrays.fill(prime, true);

        calcPrime();
        System.out.println(calcAlmostPrime(a, b));
    }

    public static void calcPrime() {
        prime[0] = prime[1] = false;

        for (int i = 2; i <= 10_000_000; i++) {
            if (prime[i]) {
                for (int j = 2 * i; j <= 10_000_000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static long calcAlmostPrime(long a, long b) {
        long cnt = 0;

        for (int i = 2; i <= 10_000_000; i++) {
            if (prime[i]) {
                long temp = i;

                while ((double)i <= (double)b / (double)temp) {
                    if ((double)i >= (double)a / (double)temp) {
                        cnt++;
                    }

                    temp *= i;
                }
            }
        }

        return cnt;
    }
}