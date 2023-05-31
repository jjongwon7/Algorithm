package AlgoBasic2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class n_13913 {
    static boolean[] check = new boolean[100001];
    static int[] parent = new int[100001];

    public static void BFS(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        check[n] = true;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int i = 0; i < 3; i++) {
                int child = 0;
                switch (i) {
                    case 0:
                        child = val - 1;
                        break;
                    case 1:
                        child = val + 1;
                        break;
                    case 2:
                        child = val * 2;
                }
                if (child >= 0 && child <= 100000) {
                    if (child == k) {
                        parent[child] = val;
                        return;
                    }
                    if (check[child] == false) {
                        check[child] = true;
                        parent[child] = val;
                        queue.offer(child);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        BFS(n, k);
        Stack<Integer> stack = new Stack<>();
        int val = k;
        while (n != val) {
            stack.add(val);
            val = parent[val];
        }
        stack.add(n);
        StringBuilder sb = new StringBuilder();
        sb.append(stack.size() - 1).append("\n");
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }
}
