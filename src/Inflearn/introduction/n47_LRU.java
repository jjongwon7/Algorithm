package Inflearn.introduction;

import java.util.Scanner;

public class n47_LRU {
    public static int[] solution(int s, int n, int[] num) {
        int[] cache = new int[s];
        for (int i = 0; i < n; i++) {
            int pos = -1;
            for (int j = 0; j < s; j++) {
                if (cache[j] == num[i]) {
                    pos = j;
                    break;
                }
            }
            // miss인 경우
            if (pos == -1) {
                for (int j = s - 2; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }
                cache[0] = num[i];
            }
            // hit인 경우
            else {
                for (int j = pos - 1; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }
                cache[0] = num[i];
            }
        }
        return cache;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        for(int i : solution(s, n, num)) {
            System.out.print(i + " ");
        }
    }
}

