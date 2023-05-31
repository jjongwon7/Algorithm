package Inflearn.introduction;

import java.util.Scanner;

public class n14_보이는학생 {
    public static int solution(int n, int[] num) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(max < num[i]) {
                ans++;
                max = num[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[] = new int[n];
        for(int i=0; i<n; i++)
            num[i] = sc.nextInt();
        System.out.println(solution(n, num));
    }
}