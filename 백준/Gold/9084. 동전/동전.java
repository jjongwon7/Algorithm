import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            System.out.println(dp(m, coins));
        }
    }

    public static int dp(int m, int[] coins) {
        int[] mem = new int[m + 1];

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j < mem.length; j++) {
                // 초기화 (동전과 현재 금액이 동일한 경우)
                if (j == coin) {
                    mem[j] += 1;
                } else {
                    mem[j] += mem[j - coin];
                }
            }
        }

        return mem[m];
    }
}