import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]); // 단원 개수
        int t = Integer.parseInt(split[1]); // 총 시간
        int[] k = new int[n + 1]; // 단원 별 예상 공부 시간
        int[] s = new int[n + 1]; // 단원 별 문제의 배점

        for (int i = 1; i <= n; i++) {
            split = br.readLine().split(" ");

            k[i] = Integer.parseInt(split[0]);
            s[i] = Integer.parseInt(split[1]);
        }

        dp(n, t, k, s);
    }

    public static void dp(int n, int t, int[] k, int[] s) {
        int[][] mem = new int[n + 1][t + 1]; // row: chapter, col: time

        // 냅색 알고리즘
        for (int chapter = 1; chapter <= n; chapter++) {
            for (int time = 1; time <= t; time++) {
                // 해당 위치에 물건을 넣을 수 없는 경우
                if (time < k[chapter]) {
                    mem[chapter][time] = mem[chapter - 1][time];
                }
                // 해당 위치에 물건을 넣을 수 있는 경우
                else {
                    mem[chapter][time] = Math.max(mem[chapter - 1][time],
                            mem[chapter - 1][time - k[chapter]] + s[chapter]);
                }
            }
        }

        System.out.println(mem[n][t]);
    }
}