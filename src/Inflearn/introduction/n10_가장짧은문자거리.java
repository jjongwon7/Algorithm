package Inflearn.introduction;

import java.util.Scanner;

public class n10_가장짧은문자거리 {
    public static int[] solution(String str, char c) {
        char[] strs = str.toCharArray();
        int[] ans = new int[str.length()];
        int len = 0, i = 0;
        for(char t : strs) {
            if (t == c) {
                len = 0;
            } else {
                len++;
            }
            ans[i++] = len;
        }
        for(i=str.length()-1, len = 0; i>=0; i--) {
            char t = strs[i];
            if (t == c) {
                len = 0;
            } else {
                len++;
            }
            ans[i] = Math.min(ans[i], len);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for(int n : solution(str, c))
            System.out.print(n + " ");
    }
}