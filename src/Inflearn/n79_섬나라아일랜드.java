package Inflearn;

import java.util.Scanner;

public class n79_섬나라아일랜드 {
    static int n;
    static int[][] board, check;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void DFS(int x, int y) {
        board[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (board[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        n = sc.nextInt();
        board = new int[n][n];
        check = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    DFS(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
