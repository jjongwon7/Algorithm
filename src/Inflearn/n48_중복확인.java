package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n48_중복확인 {
    public static char solution(int n, int[] num) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i : num) {
            if(!queue.isEmpty())
                if(queue.contains(i))
                    return 'D';
            queue.offer(i);
        }
        return 'U';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = sc.nextInt();
        System.out.println(solution(n, num));
    }
}
