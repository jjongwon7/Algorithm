import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                // 0: 빈 벽, 1: 벽, 2: 바이러스
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);

        System.out.println(ans);
    }

    public static void buildWall(int depth) {
        if (depth == 3) {
            calcMaxSafeAreaCnt();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void calcMaxSafeAreaCnt() {
        Queue<Point> queue = new LinkedList<>();

        int[][] simulationMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            simulationMap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (simulationMap[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = virus.x + dx[i];
                int nextY = virus.y + dy[i];

                if (nextX < n && nextY < m && nextX >= 0 && nextY >= 0 && simulationMap[nextX][nextY] == 0) {
                    simulationMap[nextX][nextY] = 2;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (simulationMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        ans = Math.max(ans, cnt);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}