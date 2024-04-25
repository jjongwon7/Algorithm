import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp(n, 0);
        System.out.println(ans);
    }

    public static void dp(int n, int cnt) {
        if (flag || n < 0) {
            return;
        }

        if (n == 0) {
            if (cnt % 2 == 1) {
                ans = "SK";
            } else {
                ans = "CY";
            }

            flag = true;
            return;
        }

        dp(n - 3, cnt + 1);
        dp(n - 1, cnt + 1);
    }
}