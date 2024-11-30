import java.io.*;
import java.util.*;

public class Main {

    static long[] totalCounts, pattyCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        totalCounts = new long[n];
        pattyCounts = new long[n];
        initCounts(totalCounts, pattyCounts, n);

        System.out.println(recursive(n, x));
    }

    public static void initCounts(long[] totalCounts, long[] pattyCounts, int n) {
        totalCounts[0] = 1;
        pattyCounts[0] = 1;

        for (int i = 1; i < n; i++) {
            totalCounts[i] = 3 + totalCounts[i - 1] * 2;
            pattyCounts[i] = 1 + pattyCounts[i - 1] * 2;
        }
    }

    public static long recursive(int n, long x) {
        // x가 0인 경우 패티를 먹을 수 없음
        if (x == 0) {
            return 0;
        }

        // 레벨 0인 경우
        if (n == 0) {
            return 1;
        }

        // 중간 패티 위치보다 작은 경우
        if (x < 2 + totalCounts[n - 1]) {
            return recursive(n - 1, x - 1);
        }

        // 중간 패티 위치인 경우
        if (x == 2 + totalCounts[n - 1]) {
            return pattyCounts[n - 1] + 1;
        }

        // 중간 패티 위치보다 큰 경우
        if (x > 2 + totalCounts[n - 1]) {
            return pattyCounts[n - 1] + 1 + recursive(n - 1, x - (2 + totalCounts[n - 1]));
        }

        // 현재 햄버거의 총 재료 수와 같은 경우
        return pattyCounts[n - 1] * 2 + 1;
    }
}