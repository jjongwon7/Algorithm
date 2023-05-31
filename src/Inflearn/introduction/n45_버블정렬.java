package Inflearn.introduction;

import java.util.Scanner;

public class n45_버블정렬 {
    public static int[] solution(int n, int[] num) {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(num[j] > num[j+1]) {
                    int tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
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
