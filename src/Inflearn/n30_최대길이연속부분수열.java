package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n30_최대길이연속부분수열 {
    public static int solution(int n, int k, int[] num) {
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int cnt = 0, knum = 0, lt = 0;
        for(int i=0; i<n; i++) {
            if(num[i] == 0 && knum < k) {
                queue.add(i);
                knum++;
            }
            else if(num[i] == 0 && knum == k) {
                cnt = (i-1)-queue.remove();
                System.out.println(cnt);
                queue.add(i);
            }
            cnt++;
            if(max < cnt)
                max = cnt;
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
