package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class n52_뮤직비디오_결정알고리즘 {
    public static Boolean isPossible(int n, int m, int[] num, int mid) {
        int cnt = 1;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if((sum + num[i]) <= mid) {
                sum += num[i];
            } else {
                sum = num[i];
                cnt++;
            }
        }
        if(cnt > m)
            return false;
        else return true;
    }
    public static int solution(int n, int m, int[] num) {
        int lt = Arrays.stream(num).max().getAsInt();
        int rt = Arrays.stream(num).sum();
        int ans = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(isPossible(n, m, num, mid)) {
                rt = mid - 1;
                ans = mid;
            }
            else lt = mid + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, num));
    }
}
