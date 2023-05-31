package Inflearn.introduction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n30_최대길이연속부분수열 {
    public static int solution(int n, int k, int[] num) {
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int rt=0; rt<n; rt++) {
            if (num[rt] == 1) {
                cnt++;
            } else if (num[rt] == 0) {
                if (queue.size() < k) cnt++;
                else cnt = rt - queue.remove();
                queue.add(rt);
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i]=sc.nextInt();
        System.out.println(solution(n, k, num));
    }
}