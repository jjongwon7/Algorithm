import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 지폐의 금액
        int k = Integer.parseInt(br.readLine()); // 동전의 가지 수
        int[] n = new int[k + 1];
        int[] p = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            n[i] = Integer.parseInt(st.nextToken());
        }

        dp(t, k, p, n);
    }

    public static void dp(int t, int k, int[] p, int[] n) {
        int[][] mem = new int[k + 1][t + 1];

        mem[0][0] = 1;

        // 동전 순회
        for (int coinNum = 1; coinNum <= k; coinNum++) {
            // 하나도 넣지 않을 때부터 모두 넣을 때까지 순회
            for (int cnt = 0; cnt <= n[coinNum]; cnt++) {
                // 비용 모두 순회
                for (int cost = 0; cost <= t; cost++) {
                    // 현재 비용
                    int totalCost = cost + p[coinNum] * cnt;

                    // 현재 비용이 목표 금액을 초과한 경우 예외 처리
                    if (totalCost > t) {
                        break;
                    }

                    mem[coinNum][totalCost] += mem[coinNum - 1][cost];
                }
            }
        }

        System.out.println(mem[k][t]);
    }
}