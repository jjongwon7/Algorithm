package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class n18_뒤집은소수 {
    public static ArrayList<Integer> solution(int n, int[] num) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] rvs = new int[n];
        for(int i=0; i<n; i++) {
            while(num[i] != 0) {
                int tmp = num[i] % 10;
                rvs[i] = rvs[i] * 10 + tmp;
                num[i] = num[i] / 10;
            }
            if(isPrime(rvs[i]))
                ans.add(rvs[i]);
        }
        return ans;
    }
    public static boolean isPrime(int n) {
        if(n < 2)
            return false;
        for(int i=2; i<n; i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = sc.nextInt();
        for(int i : solution(n, num))
            System.out.print(i + " ");
    }
}
