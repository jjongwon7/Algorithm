package Inflearn.introduction;

import java.util.Scanner;

public class n59_부분집합구하기_DFS {
    static int n;
    static int[] ch;
    public static void DFS(int L) {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    sb.append(i + " ");
                }
            }
            if (!sb.isEmpty()) {
                System.out.println(sb);
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n + 1];
        DFS(1);
    }
}
