package Inflearn.introduction;

import java.util.Scanner;

public class n72_순열구하기 {
    static int n, m;
    static int[] num;
    static int[] check;
    static int[] ans;
    public static void DFS(int idx) {
        if (idx == m) {
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    ans[idx] = num[i];
                    check[i] = 1;
                    DFS(idx + 1);
                    check[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        check = new int[n];
        ans = new int[m];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        DFS(0);
    }
}
