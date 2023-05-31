package Inflearn.introduction;

import java.util.Scanner;

public class n44_선택정렬 {
    public static int[] solution(int n, int[] num) {
        for(int i=0; i<n-1; i++) {
            int idx = i;
            for(int j=i; j<n; j++) {
                if(num[idx] > num[j]) {
                    idx = j;
                }
            }
            int tmp = num[i];
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
