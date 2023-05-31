package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Scanner;

public class n80_피자배달거리_삼성SW역량평가기출문제_DFS {
    static int n, m, len, ans = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pizza;
    static ArrayList<Point> home;

    public static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : home) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(pizza.get(i).x - h.x) + Math.abs(pizza.get(i).y - h.y));
                }
                sum += dis;
            }
            ans = Math.min(ans, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pizza = new ArrayList<>();
        home = new ArrayList<>();
        int val;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                val = sc.nextInt();
                if (val == 2)
                    pizza.add(new Point(i, j));
                else if (val == 1)
                    home.add(new Point(i, j));
            }
        }
        len = pizza.size();
        combi = new int[m];
        DFS(0, 0);
        System.out.println(ans);
    }
}
