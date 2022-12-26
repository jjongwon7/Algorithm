package Inflearn;

import java.util.Scanner;

public class n21_격자판최대합 {
    public static int solution(int n, int[][] num) {
        int max = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0;
        for(int i=0; i<n; i++) {
            sum1 = sum2 = 0;
            for(int j=0; j<n; j++) {
                sum1 += num[i][j];
                sum2 += num[j][i];
            }
            max = Math.max(sum1, max);
            max = Math.max(sum2, max);
        }
        sum1 = sum2 = 0;
        for(int i=0; i<n; i++) {
            sum1 += num[i][i];
            sum2 += num[i][n-i-1];
        }
        max = Math.max(sum1, max);
        max = Math.max(sum2, max);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, num));
    }
}
