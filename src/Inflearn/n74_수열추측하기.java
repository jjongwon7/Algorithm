package Inflearn;

import java.util.Scanner;

public class n74_수열추측하기 {
    static int n, f;
    static int[] combi, arr, ch;
    static Boolean flag = false;
    public static int setting(int cn, int cr) {
        if (cn == cr || cr == 0) {
            return 1;
        } else {
            return setting(cn - 1, cr - 1) + setting(cn - 1, cr);
        }
    }
    public static void DFS(int idx, int sum) {
        if (idx == n) {
            if(sum == f)
                flag = true;
        } else if (flag || sum > f) {
            return ;
        } else {
            for (int i = 0; i < n; i++) {
                if (flag)
                    return;
                if (ch[i] == 1) {
                    continue;
                }
                arr[idx] = i + 1;
                ch[i] = 1;
                DFS(idx + 1, sum + (arr[idx] * combi[idx]));
                ch[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        combi = new int[n];
        arr = new int[n];
        ch = new int[n+1];
        for (int i = 0; i < n; i++) {
            combi[i] = setting(n-1, i);
        }
        DFS(0, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
