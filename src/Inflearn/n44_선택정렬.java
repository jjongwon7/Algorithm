package Inflearn;

import java.util.Scanner;

public class n44_선택정렬 {
    public static int[] solution(int n, int[] num) {
        for(int i=0; i<n-1; i++) {
            int min = Integer.MAX_VALUE;
            int idx=0;
            int tmp;
            for(int j=i; j<n; j++) {
                if(min > num[j]) {
                    min = num[j];
                    idx = j;
                }
            }
            tmp = num[i];
            num[i] = num[idx];
            num[idx] = tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        for(int i : solution(n, num)) {
            System.out.print(i + " ");
        }
    }
}
