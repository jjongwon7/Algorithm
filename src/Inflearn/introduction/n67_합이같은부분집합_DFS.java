package Inflearn.introduction;

import java.util.Scanner;

public class n67_합이같은부분집합_DFS {
    static int sum;
    static int n;
    static int[] num;
    static String ans = "NO";
    public static void DFS(int idx, int cursum) {
        if (ans.equals("YES"))
            return ;
        if (cursum > sum / 2)
            return ;
        if (idx == n) {
            if (sum == (cursum * 2))
                ans = "YES";
        }
        else {
                DFS(idx + 1, cursum + num[idx]);
                DFS(idx + 1, cursum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            sum += num[i];
        }
        DFS(0, 0);
        System.out.println(ans);
    }
}
