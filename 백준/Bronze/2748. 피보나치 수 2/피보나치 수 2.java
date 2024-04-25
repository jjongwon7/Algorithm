import java.io.*;

public class Main {

    public static long[] fibo = new long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo[1] = 1;
        dp(2);
        System.out.println(fibo[n]);
    }

    public static void dp(int n) {
        if (n == 91) {
            return;
        }
        fibo[n] = fibo[n - 1] + fibo[n - 2];
        dp(n + 1);
    }
}