package AlgoBasic2;

import java.util.Scanner;

public class n_15650 {
    static int n, m;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb;

    public static void DFS(int L, int pre) {
        if (L == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return ;
        }
        for (int i = 1; i <= n; i++) {
            if (check[i] == false && i > pre) {
                check[i] = true;
                arr[L] = i;
                DFS(L + 1, i);
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
        DFS(0, 0);
        System.out.println(sb);

    }
}
