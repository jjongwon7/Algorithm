package Inflearn.introduction;

import java.util.Scanner;

public class n46_삽입정렬 {
    public static int[] solution(int n, int[] num) {
        for(int i = 1; i < n; i++) {
            int key = num[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (num[j] > key) {
                    num[j + 1] = num[j];
                } else
                    break;
            }
            num[j+1] = key;
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
