package Inflearn.introduction;

import java.util.Scanner;

public class n75_조합구하기 {
    static int n, m;
    static int[] arr, ch;
    public static void DFS(int idx) {
        if (idx == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    if (idx == 0 || (idx != 0 && arr[idx - 1] < i)) {
                        ch[i] = 1;
                        arr[idx] = i;
                        DFS(idx + 1);
                        ch[i] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        ch = new int[n + 1];
        DFS(0);
    }
}
