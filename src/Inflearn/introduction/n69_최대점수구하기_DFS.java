package Inflearn.introduction;

import java.util.Scanner;

public class n69_최대점수구하기_DFS {
    static int n, m;
    static int[] score, time;
    static int ans = 0;

    public static void DFS(int idx, int curTime, int curScore) {
        if (curTime > m) {
            return;
        }
        if (idx == n) {
            ans = Math.max(ans, curScore);
        } else {
            DFS(idx + 1, curTime + time[idx], curScore + score[idx]);
            DFS(idx + 1, curTime, curScore);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        DFS(0, 0, 0);
        System.out.println(ans);
    }
}