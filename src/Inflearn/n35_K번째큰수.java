package Inflearn;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class n35_K번째큰수 {
    public static int solution(int n, int k, int[] num) {
        int ans = -1;
        int cnt = 1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int m=j+1; m<n; m++) {
                    treeSet.add(num[i]+num[j]+num[m]);
                }
            }
        }
        for(int i : treeSet) {
            if(cnt++ == k)
                return i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i< n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(solution(n, k, num));
    }
}
