package Inflearn.introduction;

import java.util.Scanner;

public class n89_돌다리건너기 {
    static int[] dp;
    public static int solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n + 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 2];
        System.out.println(solution(n));
    }
}
