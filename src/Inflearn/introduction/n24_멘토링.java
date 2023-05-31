package Inflearn.introduction;

import java.util.Scanner;

public class n24_멘토링 {
    public static int solution(int n, int m, int[][] num) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    int cnt = 0;
                    for (int k = 0; k < m; k++) {
                        int pi = 0;
                        int pj = 0;
                        for (int l = 0; l < n; l++) {
                            if (num[k][l] == i) {
                               pi = l;
                            } else if (num[k][l] == j) {
                                pj = l;
                            }
                        }
                        if (pi < pj) {
                            break;
                        } else {
                            cnt++;
                        }
                    }
                    if (cnt == m) {
                        ans++;
                    }
                }
            }
        }
        return ans;
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
