package Inflearn;

import java.util.Scanner;

public class n20_등수구하기 {
    public static int[] solution(int n, int[] num) {
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int grade = 1;
            for(int j=0; j<n; j++) {
                if(num[j]>num[i])
                    grade++;
            }
            ans[i] = grade;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        for(int i : solution(n, num))
            System.out.print(i + " ");
    }
}
