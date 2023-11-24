import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sum = new long[n];
        long[] modValueCnt = new long[m];
        long ans = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum[i] = Integer.parseInt(st.nextToken());
            } else {
                sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int modValue = (int)(sum[i] % m);
            modValueCnt[modValue]++;

            if (modValue == 0) {
                ans++;
            }
        }

        for (int i = 0; i < m; i++) {
            if (modValueCnt[i] >= 2) {
                ans += combi(modValueCnt[i]);
            }
        }

        System.out.println(ans);
    }

    private static long combi(long n) {
        return (n * (n - 1)) / 2;
    }
}