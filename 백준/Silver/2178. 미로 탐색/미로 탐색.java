import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] depth;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        depth = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                board[i + 1][j + 1] = chars[j];
            }
        }

        bfs();

    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        depth[1][1] = 1;
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == n && cur.y == m) {
                System.out.println(depth[n][m]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if (nextX > 0 && nextY > 0 && nextX <= n && nextY <= m) {
                    if (!visited[nextX][nextY] && board[nextX][nextY] == '1') {
                        queue.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        depth[nextX][nextY] = depth[cur.x][cur.y] + 1;
                    }
                }
            }
        }
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