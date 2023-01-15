package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        sb.append(ans);
        System.out.println(sb);
    }
}
