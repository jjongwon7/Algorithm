package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_15990 {

    public static void DP(long[][] arr) {
        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = arr[3][2] = arr[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            arr[i][1] = (arr[i - 1][2] + arr[i - 1][3]) % 1_000_000_009;
            arr[i][2] = (arr[i - 2][1] + arr[i - 2][3]) % 1_000_000_009;
            arr[i][3] = (arr[i - 3][1] + arr[i - 3][2]) % 1_000_000_009;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer stringBuffer = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        long[][] arr = new long[100001][4];
        DP(arr);
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            stringBuffer.append((arr[n][1] + arr[n][2] + arr[n][3]) % 1_000_000_009).append("\n");
        }
        System.out.println(stringBuffer);
    }
}
