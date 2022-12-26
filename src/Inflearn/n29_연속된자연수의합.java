package Inflearn;

import java.util.Scanner;

public class n29_연속된자연수의합 {
    public static int solution(int n) {
        int[] num = new int[n+1];
        int sum = 0, ans = 0;
        int lt = 1;
        for(int i=1; i<=n; i++)
            num[i] = i;
        for(int rt=1; rt<=n; rt++) {
            sum += num[rt];
            if(sum == n && lt != rt)
                ans++;
            else {
                while(sum > n) {
                    sum -= num[lt++];
                    if(sum == n && lt != rt)
                        ans++;
                }
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
