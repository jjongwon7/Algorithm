package AlgoBasic1;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n_1158 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        sb.append('<');
        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();

        for(int i=1;i<=N;i++)
            queue.add(i);

        while(!queue.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    sb.append(queue.remove());
                    if(!queue.isEmpty())
                        sb.append(", ");
                }
                else
                    queue.add(queue.remove());
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}

