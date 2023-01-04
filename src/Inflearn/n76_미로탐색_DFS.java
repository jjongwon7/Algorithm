package Inflearn;

import java.util.Scanner;

public class n76_미로탐색_DFS {
    static int[][] board ;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;
    public static void DFS(int x, int y) {
        if (x == 7 && y == 7) ans++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx == 0 || nx == 8 || ny == 0 || ny == 8 || board[nx][ny] == 1)
                    ;
                else {
                    board[x][y] = 1;
                    DFS(nx, ny);
                    board[x][y] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        DFS(1, 1);
        System.out.println(ans);
    }
}
