package Inflearn.introduction;

import java.util.Scanner;

public class n70_중복순열 {
    static int n, m;
    static int[] ans;
    public static void DFS(int idx) {
        if (idx == m) {
            for (int i : ans)
                System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                ans[idx] = i;
                DFS(idx + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ans = new int[m];
        DFS(0);
    }
}
