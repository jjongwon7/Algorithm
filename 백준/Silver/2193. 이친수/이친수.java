import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        arr = new long[(int) n][2];

        arr[0][0] = 0;
        arr[0][1] = 1;

        for (int i = 1; i < n; i++) {
            dp(i);
        }

        System.out.println(arr[(int) (n-1)][0] + arr[(int) (n-1)][1]);

    }

    public static void dp(int i) {
        arr[i][0] = arr[i - 1][1] + arr[i - 1][0];
        arr[i][1] = arr[i - 1][0];
    }
}