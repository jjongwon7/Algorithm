package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class n51_이분검색 {
    public static int solution(int n, int m, int[] num) {
        Arrays.sort(num);
        int lt = 0;
        int rt = n-1;
        int ans = 0;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if (num[mid] == m) {
                ans = mid + 1;
                break;
            }
            else if (num[mid] < m)
                lt = mid+1;
            else if (num[mid] > m)
                rt = mid-1;
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
