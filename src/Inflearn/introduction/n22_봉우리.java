package Inflearn.introduction;

import java.util.Scanner;

public class n22_봉우리 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int solution(int n, int[][] num) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                        if (num[i][j] <= num[nx][ny]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    ans++;
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
