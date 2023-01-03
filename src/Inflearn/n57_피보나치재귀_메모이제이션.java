package Inflearn;

import java.util.Scanner;

public class n57_피보나치재귀_메모이제이션 {
    static int[] fibo;
    public static int DFS(int n) {
        if (fibo[n] != 0)
            return fibo[n];
        if (n == 1)
            return fibo[n] = 1;
        else if (n == 2)
            return fibo[n] = 1;
        else
            return fibo[n] = DFS(n-1) + DFS(n-2);
    }

    public static void main(String[] args) {
        int n=10;
        fibo = new int[n+1];
        DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}
