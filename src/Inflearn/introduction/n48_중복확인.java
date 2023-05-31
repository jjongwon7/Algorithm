package Inflearn.introduction;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n48_중복확인 {
    public static char solution(int n, int[] num) {
        Arrays.sort(num);
        for (int i = 0; i < n-1; i++) {
            if (num[i] == num[i + 1]) {
                return 'D';
            }
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
