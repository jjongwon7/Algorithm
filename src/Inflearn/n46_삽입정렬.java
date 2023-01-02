package Inflearn;

import java.util.Scanner;

public class n46_삽입정렬 {
    public static int[] solution(int n, int[] num) {
        int tmp = 0;
        for(int i=1; i<n; i++) {
            for(int j=i; j>0; j--) {
                if(num[j] < num[j-1]) {
                    tmp = num[j];
                    num[j] = num[j-1];
                    num[j-1] = tmp;
                }
                else break;
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
