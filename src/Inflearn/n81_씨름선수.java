package Inflearn;

import java.util.Scanner;

public class n81_씨름선수 {
    public static int solution(int n, int[][] num) {
        int ans = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(num[i][0] > num[j][0])
                    ;
                else if(num[i][1] > num[j][1])
                    ;
                else if(num[i][0] == num[j][0] && num[i][1] == num[j][1])
                    ;
                else {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, num));

    }
}
