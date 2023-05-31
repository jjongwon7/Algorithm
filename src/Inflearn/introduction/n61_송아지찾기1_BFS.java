package Inflearn.introduction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n61_송아지찾기1_BFS {
    int ans = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> queue = new LinkedList<>();
    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        queue.offer(s);
        int L=0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int val = queue.poll();
                if (val == e) {
                    ans = L;
                    return ans;
                } else {
                    if (ch[dis[0] + val] != 1) {
                        queue.offer(dis[0] + val);
                        ch[dis[0] + val] = 1;
                    }
                    if ((dis[1] + val) > 0 && ch[dis[1] + val] != 1) {
                        queue.offer(dis[1] + val);
                        ch[dis[1] + val] = 1;
                    }
                    if (ch[dis[2] + val] != 1) {
                        queue.offer(dis[2] + val);
                        ch[dis[2] + val] = 1;
                    }
                }
            }
            L++;
        }
        return ans;
    }

    public static void main(String[] args) {
        n61_송아지찾기1_BFS T = new n61_송아지찾기1_BFS();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
