package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_17087 {
    public static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return GCD(b, a % b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dis = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dis[i] = Math.abs(s - arr[i]);
        }
        int gcd = dis[0];
        for (int i = 1; i < n; i++) {
            gcd = GCD(gcd, dis[i]);
        }
        System.out.println(gcd);
    }
}
