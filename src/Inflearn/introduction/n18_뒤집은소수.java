package Inflearn.introduction;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class n18_뒤집은소수 {
    static StringBuilder sb = new StringBuilder();
    public static void solution(int[] num) {
        int[] prime = new int[100001];
        for (int i = 2; i <= 100000; i++) {
            if (prime[i] == 0) {
                for (int j = i * 2; j <= 100000; j += i) {
                    prime[j] = 1;
                }
            }
        }
        for (int i : num) {
            if (prime[i] == 0 && i != 1) {
                sb.append(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            StringBuilder reverse = new StringBuilder(st.nextToken()).reverse();
            num[i] = Integer.parseInt(reverse.toString());
        }
        solution(num);
        System.out.println(sb);
    }
}
