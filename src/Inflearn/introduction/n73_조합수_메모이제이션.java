package Inflearn.introduction;

import java.util.Scanner;

public class n73_조합수_메모이제이션 {
    static int n, r;
    static int[][] ch;
    public static int DFS(int cn, int cr) {
        if (cr == 0 || cn == cr) {
            return 1;
        } else if (ch[cn][cr] != 0) {
            return ch[cn][cr];
        } else {
            return ch[cn][cr] = DFS(cn - 1, cr - 1) + DFS(cn - 1, cr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        ch = new int[n+1][r+1];
        System.out.println(DFS(n, r));
    }
}
