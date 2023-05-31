package Inflearn.introduction;

import java.util.Scanner;

public class n93_최대점수구하기_냅색알고리즘 {
    public static int solution(int n, int m, int[] score, int[] time) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= time[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-time[i]]+score[i]);
            }
        }
        return dp[m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] score = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, score, time));
    }
}
