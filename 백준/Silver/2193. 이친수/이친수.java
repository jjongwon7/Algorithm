import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void DP(long[][] arr) {
        arr[1][1] = 1;
        for (int i = 2; i <= 90; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-1][1];
            arr[i][1] = arr[i-1][0];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        long[][] arr = new long[91][2];
        DP(arr);
        System.out.println(arr[n][0] + arr[n][1]);
    }
}