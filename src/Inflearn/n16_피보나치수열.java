package Inflearn;

import java.util.Scanner;

public class n16_피보나치수열 {
    public static int[] solution(int n) {
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            if(i==0 || i==1)
                ans[i] = 1;
            else
                ans[i] = ans[i-2] + ans[i-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i : solution(n))
            System.out.print(i + " ");
    }
}
