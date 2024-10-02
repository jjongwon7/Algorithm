import java.io.*;
import java.util.*;

public class Main {

    static char[][] map = new char[5][5];
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int answer = 0;
    static int[][] arr = new int[7][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        comb(0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void comb(int depth, int sCnt, int yCnt, int value) {
        // backtracking
        if (yCnt == 4) {
            return;
        }

        if (depth == 7) {
            if (isCorrect()) {
                answer++;
            }

            return;
        }

        if (value == 25) {
            return;
        }

        int r = value / 5;
        int c = value % 5;

        comb(depth, sCnt, yCnt, value + 1);

        if (map[r][c] == 'Y') {
            arr[depth][0] = r;
            arr[depth][1] = c;
            comb(depth + 1, sCnt, yCnt + 1, value + 1);
        } else {
            arr[depth][0] = r;
            arr[depth][1] = c;
            comb(depth + 1, sCnt + 1, yCnt, value + 1);
        }
    }

    public static boolean isCorrect() {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];
        queue.offer(new Point(arr[0][0], arr[0][1]));
        visited[0] = false;
        int cnt = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = point.r + dr[i];
                int nc = point.c + dc[i];

                for (int next = 1; next < 7; next++) {
                    if (nr >=0 && nc >= 0 && nr < 5 && nc < 5 && !visited[next] && nr == arr[next][0] && nc == arr[next][1]) {
                        visited[next] = true;
                        queue.offer(new Point(nr, nc));
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 7) {
            return true;
        }

        return false;
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