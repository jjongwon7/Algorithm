package Inflearn;

import java.util.Scanner;

public class n28_연속부분수열 {
    public static int solution(int n, int m, int[] num) {
        int sum = 0;
        int ans = 0, lt = 0;
        for(int rt=0; rt<n; rt++) {
            sum += num[rt];
            if(sum == m)
                ans++;
            else {
                while(sum >= m) {
                    sum -= num[lt++];
                    if (sum == m)
                        ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = sc.nextInt();
        System.out.println(solution(n, m, num));
    }
}
