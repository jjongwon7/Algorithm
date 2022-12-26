package Inflearn;

import java.util.*;

public class n25_두배열합치기 {
    public static int[] solution(int n, int m, int[] num1, int[] num2) {
        int n1 = 0, n2 = 0, idx = 0;
        int[] ans = new int[n+m];
        while(n1 < n && n2 < m) {
            if(num1[n1] > num2[n2])
                ans[idx++] = num2[n2++];
            else
                ans[idx++] = num1[n1++];
        }
        while(n1 < n)
            ans[idx++] = num1[n1++];
        while(n2 < m)
            ans[idx++] = num2[n2++];
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num1 = new int[n];
        for(int i=0; i<n; i++) {
            num1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] num2 = new int[m];
        for(int i=0; i<m; i++) {
            num2[i] = sc.nextInt();
        }
        for(int i : solution(n, m, num1, num2))
            System.out.print(i + " ");
    }
}
