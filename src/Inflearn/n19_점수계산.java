package Inflearn;

import java.util.Scanner;

public class n19_점수계산 {
    public static int solution(int n, int[] num) {
        int weight = 0;
        int sum = 0;
        for(int i : num) {
            if(i == 0)
                weight = 0;
            else
                sum += ++weight;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(solution(n, num));
    }
}
