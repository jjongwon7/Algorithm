package Inflearn.introduction;

import java.util.Scanner;

public class n56_팩토리얼 {
    public static int DFS(int n) {
        if (n == 1)
            return 1;
        else
            return n * DFS(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(DFS(n));
    }
}
