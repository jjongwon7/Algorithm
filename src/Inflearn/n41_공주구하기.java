package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n41_공주구하기 {
    public static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++)
            queue.offer(i);

        while(queue.size() > 1) {
            for(int i=0; i<k-1; i++)
                queue.offer(queue.poll());
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }
}
