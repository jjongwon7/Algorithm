package Inflearn.introduction;

import java.util.Arrays;
import java.util.Scanner;

public class n53_마구간정하기_결정알고리즘 {
    public static int count(int n, int[] num, int mid) {
        int ep =0;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if(num[i] - num[ep] >= mid) {
                ep = i;
                cnt++;
            }
        }
        return cnt;
    }
    public static int solution(int n, int c, int[] num) {
        Arrays.sort(num);
        int lt = 1;
        int rt = num[n-1];
        int ans = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(n, num, mid) >= c) {
                ans = mid;
                lt = mid + 1;
            }
            else rt = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(solution(n, c, num));
    }
}
