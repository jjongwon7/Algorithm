package Inflearn.introduction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n71_동전교환 {
    static int n, m;
    static int[] num;
    static int ans = Integer.MAX_VALUE;
    public static void DFS(int cnt, int sum){
        if (sum > m) {
            return;
        }
        if (cnt >= ans) {
            return;
        }
        if(sum==m){
            ans = Math.min(ans, cnt);
        }
        else{
            for(int i=0; i<n; i++){
                DFS(cnt + 1, sum + num[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        m = sc.nextInt();
        DFS(0, 0);
        System.out.println(ans);
    }
}
