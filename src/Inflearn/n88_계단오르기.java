package Inflearn;

import java.util.Scanner;

public class n88_계단오르기 {
    static int n;
    static int ans;
    public static void DP(int sum) {
        if (sum == n) {
            ans++;
            return ;
        }
        if (sum > n) {
            return ;
        }
        DP(sum + 1);
        DP(sum + 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DP(0);
        System.out.println(ans);
    }
}
