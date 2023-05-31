package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Scanner;

public class n13_큰수출력하기 {
    public static StringBuilder solution(int n, int num[]) {
        StringBuilder sb = new StringBuilder();
        sb.append(num[0] + " ");
        for(int i=0; i<n-1; i++) {
            if(num[i+1] > num[i])
                sb.append(num[i + 1] + " ");
        }
        return sb;
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
