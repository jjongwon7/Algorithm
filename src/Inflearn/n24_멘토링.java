package Inflearn;

import java.util.Scanner;

public class n24_멘토링 {
    public static int solution(int n, int m, int[][] num) {
        boolean[][] check = new boolean[n+1][n+1];
        int cnt = 0;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=j+1; k<=n; k++) {
                    check[num[i-1][j-1]][num[i-1][k-1]] = true;
                }
            }
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(check[i][j] && check[j][i])
                    ;
                else if(check[i][j])
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                num[i][j]=sc.nextInt();
            }
        }
        System.out.println(solution(n, m, num));
    }
}
