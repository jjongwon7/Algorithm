import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] l = new int[p + 1];
        int[] c = new int[p + 1];

        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());

            l[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        dp(d, p, l, c);
    }

    public static void dp(int d, int p, int[] l, int[] c) {
        int[][] mem = new int[p + 1][d + 1];

        for (int i = 0; i <= p; i++) {
            mem[i][0] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= d; j++) {
                if (l[i] <= j && mem[i - 1][j - l[i]] != 0) { // 해당 파이프 삽입 가능 여부
                    mem[i][j] = Math.max(mem[i - 1][j], Math.min(mem[i - 1][j - l[i]], c[i]));
                } else {
                    mem[i][j] = mem[i - 1][j];
                }
            }
        }

        System.out.println(mem[p][d]);
    }
}