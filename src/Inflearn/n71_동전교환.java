package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n71_동전교환 {
    static int n, m;
    static int[] num;
    static int ans = 0;
    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(num[i]);
        }
        while(!queue.isEmpty()) {
            ans++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cur = queue.poll();
                if (cur == m) {
                    return;
                } else {
                    for (int j : num) {
                        queue.offer(cur + j);
                    }
                }
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
        BFS();
        System.out.println(ans);
    }
}
