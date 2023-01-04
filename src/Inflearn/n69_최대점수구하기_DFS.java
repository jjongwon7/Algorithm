package Inflearn;

import java.util.Scanner;

public class n69_최대점수구하기_DFS {
    static int n, m;
    static int[][] num;
    static int ans = 0;

    public static void DFS(int idx, int time, int score) {
        if (idx == n && time <= m) {
            if (ans < score)
                ans = score;
        } else if(time > m) {
            return;
        } else {
            DFS(idx + 1, time + num[idx][1], score + num[idx][0]);
            DFS(idx + 1, time, score);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        DFS(0, 0, 0);
        System.out.println(ans);
    }
}
