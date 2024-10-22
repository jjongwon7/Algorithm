import java.util.*;
import java.io.*;

public class Main {

    static int r, c, t;
    static int a[][];
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static Point[] cleaner = new Point[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        a = new int[r][c];
        int cleanerIdx = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());

                if (a[i][j] == -1) {
                    cleaner[cleanerIdx++] = new Point(i, j);
                }
            }
        }
        for (int i = 0; i < t; i++) {
            diffuse();
            activate();
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] != 0 && a[i][j] != -1) {
                    ans += a[i][j];
                }
            }
        }

        System.out.println(ans);
    }

    public static void diffuse() {
        int[][] tempArr = new int[r][c];

        for (int i = 0; i < r; i++) {
            tempArr[i] = Arrays.copyOf(a[i], c);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (tempArr[i][j] != 0 && tempArr[i][j] != -1) { // 미세먼지
                    int cnt = 0;
                    int diffusionValue = tempArr[i][j] / 5;
                    for (int t = 0; t < 4; t++) {
                        int nextR = i + dr[t];
                        int nextC = j + dc[t];

                        if (nextR >= 0 && nextC >= 0 && nextR < r && nextC < c) {
                            if (tempArr[nextR][nextC] != -1) {
                                a[nextR][nextC] += diffusionValue;
                                cnt++;
                            }
                        }
                    }
                    a[i][j] -= diffusionValue * cnt;

                }
            }
        }
    }

    public static void activate() {
        Point topOfCleaner = cleaner[0];
        Point bottomOfCleaner = cleaner[1];

        clean(topOfCleaner.r, topOfCleaner.c + 1, 0, 0, 0);
        clean(bottomOfCleaner.r, bottomOfCleaner.c + 1, 0, 0, 1);
    }

    public static void clean(int curR, int curC, int cur, int direction, int cleaner) {
        int nextR = curR + dr[direction];
        int nextC = curC + dc[direction];
        if (nextR >= 0 && nextC >= 0 && nextR < r && nextC < c) {
            int next = a[curR][curC];
            a[curR][curC] = cur;
            if (a[nextR][nextC] != -1) {
                clean(nextR, nextC, next, direction, cleaner);
            }
        } else {
            if (cleaner == 0) {
                clean(curR, curC, cur, (direction + 1) % 4, cleaner);
            } else {
                clean(curR, curC, cur, (direction + 3) % 4, cleaner);
            }
        }
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}