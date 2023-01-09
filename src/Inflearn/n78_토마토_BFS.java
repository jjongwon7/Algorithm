package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n78_토마토_BFS {
    static int m, n;
    static int[][] arr;
    static int ans = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        Boolean isDone = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
                if (arr[i][j] == 0 || arr[i][j] == -1) {
                    isDone = false;
                }
            }
        }
        if (isDone) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (arr[nx][ny] == 0) {
                            arr[nx][ny] = 1;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            if (!queue.isEmpty()) {
                ans++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(BFS());
    }
}
