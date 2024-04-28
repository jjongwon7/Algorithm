import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] stones = new int[n + 1][2]; // stones[i][0]: 작은 점프 시 소모되는 에너지, stones[i][1]: 큰 점프 시 소모되는 에너지
        int k = 0; // 매우 큰 점프 소모 에너지
        int[][] mem = new int[n + 1][2]; // mem[i][0]: 매우 큰 점프를 소모하지 않은 경우, mem[i][1]: 매우 큰 점프를 소모한 경우

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stones[i][0] = Integer.parseInt(st.nextToken());
            stones[i][1] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            Arrays.fill(mem[i], 9999999);
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                mem[1][0] = 0;
            } else if (i == 2) {
                mem[2][0] = mem[1][0] + stones[1][0];
            } else if (i == 3) {
                mem[3][0] = Math.min(mem[2][0] + stones[2][0], mem[1][0] + stones[1][1]);
            } else {
                int a = mem[i - 1][0] + stones[i - 1][0];
                int b = mem[i - 2][0] + stones[i - 2][1];
                mem[i][0] = Math.min(a, b);

                int x = mem[i - 3][0] + k;
                int y = mem[i - 2][1] + stones[i - 2][1];
                int z = mem[i - 1][1] + stones[i - 1][0];
                mem[i][1] = Math.min(x, Math.min(y, z));
            }
        }

        System.out.println(Math.min(mem[n][0], mem[n][1]));
    }
}