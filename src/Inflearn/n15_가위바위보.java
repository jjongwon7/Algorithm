package Inflearn;

import java.util.Scanner;

public class n15_가위바위보 {
    public static char solution(int i, int[] a, int[] b) {
            if((a[i] == 1) && (b[i] == 3) || (a[i] == 2) && (b[i] == 1) || (a[i] == 3) && (b[i] == 2))
                return 'A';
            else if (a[i] == b[i])
                return 'D';
            else
                return 'B';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            b[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            System.out.println(solution(i, a, b));
        }
    }
}
