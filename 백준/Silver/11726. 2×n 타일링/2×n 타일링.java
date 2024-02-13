import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        System.out.println(cal(n));
    }
    static int cal(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(dp[n] == 0)
            dp[n] = (cal(n-1) + cal(n-2)) % 10_007;
        return dp[n];
    }
}
