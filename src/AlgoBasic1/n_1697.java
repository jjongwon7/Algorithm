package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n_1697 {
    static int n, k;
    public static int BFS(int v) {
        boolean[] mem = new boolean[100001];
        int ans = 0;
        if (n == k) {
            return ans;
        }
        Queue<Integer> queue = new LinkedList<>();

        int n1 = n - 1;
        int n2 = n + 1;
        int n3 = n * 2;
        if(n1 >= 0 && n1 <= 100000 && !mem[n1])
            queue.offer(n1);
        if(n2 >= 0 && n2 <= 100000 && !mem[n2])
            queue.offer(n2);
        if(n3 >= 0 && n3 <= 100000 && !mem[n3])
            queue.offer(n3);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int rlt = queue.poll();
                if (rlt == k) {
                    ans = v;
                    return ans;
                } else {
                    mem[rlt] = true;
                    int next1 = rlt - 1;
                    int next2 = rlt + 1;
                    int next3 = rlt * 2;
                    if(next1 >= 0 && next1 <= 100000 && !mem[next1])
                        queue.offer(next1);
                    if(next2 >= 0 && next2 <= 100000 && !mem[next2])
                        queue.offer(next2);
                    if(next3 >= 0 && next3 <= 100000 && !mem[next3])
                        queue.offer(next3);
                }
            }
            v++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.println(BFS(1));
    }
}
