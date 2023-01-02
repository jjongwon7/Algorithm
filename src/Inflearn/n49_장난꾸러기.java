package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class n49_장난꾸러기 {
    public static int[] solution(int n, int[] num) {
        int[] ans = new int[2];
        int[] tmp = num.clone();
        int idx = 0;
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if(tmp[i] != num[i])
                ans[idx++] = i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        for (int i : solution(n, num)) {
            System.out.print(i + " ");
        }
    }
}
