package AlgoBasic2;

import java.util.Scanner;

public class n_15651 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void DFS(int L) {
        if (L == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        DFS(0);
        System.out.println(sb);
    }
}
