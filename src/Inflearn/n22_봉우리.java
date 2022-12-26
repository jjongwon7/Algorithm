package Inflearn;

import java.util.Scanner;

public class n22_봉우리 {
    public static int solution(int n, int[][] num) {
        int[][] isPromising = new int[n+2][n+2];
        int ans = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(isPromising[i][j] == 0) {
                    if (num[i][j] > num[i][j + 1]) {
                        isPromising[i][j + 1] = 1;
                        if (num[i][j] > num[i+1][j]) {
                            isPromising[i + 1][j] = 1;
                            if (num[i][j] > num[i-1][j] && num[i][j] > num[i][j-1])
                                ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n+2][n+2];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, num));
    }
}
