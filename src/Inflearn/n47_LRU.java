package Inflearn;

import java.util.Scanner;

public class n47_LRU {
    public static int[] solution(int s, int n, int[] num) {
        int size = 0;
        Boolean isHit;
        int hitIdx = 0;
        int[] cache = new int[s];
        for(int i=0; i<n; i++) {
            isHit = false;
            for(int j=0; j<size; j++) {
                if(cache[j] == num[i]) {
                    isHit = true;
                    hitIdx = j;
                    break;
                }
            }
            if(isHit) {
                for(int j=hitIdx-1; j>=0; j--) {
                    cache[j+1] = cache[j];
                }
            }
            else {
                for(int j=size-1; j>=0; j--) {
                    if(j == s-1) size--;
                    else cache[j + 1] = cache[j];
                }
                size++;
            }
            cache[0] = num[i];
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

