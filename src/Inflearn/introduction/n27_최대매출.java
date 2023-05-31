package Inflearn.introduction;

import java.util.Scanner;

public class n27_최대매출 {
    public static int solution(int n, int k, int[] num) {
        int max = 0, sum;
        for(int i=0; i<k; i++)
            max += num[i];
        sum = max;
        for(int i=k;i<n;i++) {
            sum += (num[i] - num[i - k]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = sc.nextInt();
        System.out.println(solution(n, k, num));
    }
}
