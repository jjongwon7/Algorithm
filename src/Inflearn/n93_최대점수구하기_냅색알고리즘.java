package Inflearn;

import java.util.Scanner;

public class n93_최대점수구하기_냅색알고리즘 {
    public static int solution(int n, int m, int[][] arr) {
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= arr[i][1]; j--) {
                dy[j] = Math.max(dy[j], dy[j-arr[i][1]]+arr[i][0]);
            }
        }
        return dy[m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
