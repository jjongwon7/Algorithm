package Inflearn;

import java.util.Scanner;

public class n23_임시반장정하기 {
    public static int solution(int n, int[][] num) {
        int max = Integer.MIN_VALUE;
        int president = 0;
        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<5; k++) {
                    if(num[i][k] == num[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(max < cnt) {
                max = cnt;
                president = i+1;
            }
        }
        return president;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][5];
        for(int i=0; i<n; i++) {
            for(int j=0; j<5; j++) {
                num[i][j]=sc.nextInt();
            }
        }
        System.out.println(solution(n, num));
    }
}
