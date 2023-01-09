package Inflearn;

import java.util.Scanner;

public class n90_최대부분증가수열 {
    static int[] dy;
    public static int solution(int[] arr) {
        int ans = 0;
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
                dy[i] = max+1;
                ans = Math.max(ans, dy[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dy = new int[n];
        System.out.println(solution(arr));
    }
}
