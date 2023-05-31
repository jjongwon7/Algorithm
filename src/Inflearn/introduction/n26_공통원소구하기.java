package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class n26_공통원소구하기 {
    public static ArrayList<Integer> solution(int n, int m, int[] num1, int[] num2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num1);
        Arrays.sort(num2);
        int n1 = 0, n2 = 0;
        while(n1 < n && n2 < m) {
            if(num1[n1] == num2[n2]) {
                list.add(num1[n1]);
                n1++;
                n2++;
            } else if (num1[n1] > num2[n2]) {
                n2++;
            } else {
                n1++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num1 = new int[n];
        for(int i=0; i<n; i++) {
            num1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] num2 = new int[m];
        for(int i=0; i<m; i++) {
            num2[i] = sc.nextInt();
        }
        for(int i : solution(n, m, num1, num2))
            System.out.print(i + " ");
    }
}
