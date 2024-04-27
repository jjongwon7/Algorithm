import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n + 1];
        int[][] mem = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                mem[1][1] = scores[1];
                mem[1][2] = 0;
            } else if (i == 2) {
                mem[2][1] = scores[2];
                mem[2][2] = scores[1] + scores[2];
            } else {
                mem[i][1] = Math.max(mem[i - 2][1], mem[i - 2][2]) + scores[i];
                mem[i][2] = mem[i - 1][1] + scores[i];
            }
        }

        System.out.println(Math.max(mem[n][1], mem[n][2]));
    }
}