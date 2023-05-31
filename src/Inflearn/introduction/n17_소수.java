package Inflearn.introduction;

import java.util.Scanner;

public class n17_소수 {
    public static int solution(int n) {
        int[] num = new int[n+1];
        int ans = 0;
        for(int i=2; i<=n; i++) {
            if(num[i] == 0) {
                ans++;
                for (int j = i; j <= n; j = j + i)
                    num[j] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
