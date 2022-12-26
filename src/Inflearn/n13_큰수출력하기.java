package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class n13_큰수출력하기 {
    public static ArrayList<Integer> solution(int n, int num[]) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(num[0]);
        for(int i=0; i<n-1; i++) {
            if(num[i+1] > num[i])
                ans.add(num[i+1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        for(int i : solution(n, num)) {
            System.out.printf(i + " ");
        }
    }
}
