package Inflearn.introduction;

import java.util.Scanner;

public class n88_계단오르기 {
    static int[] dp;
    public static int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        System.out.println(solution(n));
    }
}
