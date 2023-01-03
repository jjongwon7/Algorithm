package Inflearn;

import java.util.Scanner;

public class n68_바둑이승차_DFS {
    static int c, n;
    static int[] weight;
    static int ans = 0;

    public static void DFS(int idx, int sum) {
        if(sum > c)
            return ;
        if (idx == n) {
            if (ans < sum) {
                ans = sum;
            }
        } else {
            DFS(idx + 1, sum + weight[idx]);
            DFS(idx + 1, sum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        DFS(0, 0);
        System.out.println(ans);
    }
}
