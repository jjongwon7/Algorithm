package AlgoBasic2;

import java.util.Scanner;

public class n_15649 {
    static int n, m;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] check;
    public static void DFS(int L) {
        if (L == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(check[i] == false) {
                arr[L] = i;
                check[i] = true;
                DFS(L + 1);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        check = new boolean[n + 1];
        DFS(0);
        System.out.println(sb);
    }
}