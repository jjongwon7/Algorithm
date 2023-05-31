package Inflearn.introduction;

import java.util.Scanner;

public class n12_암호 {
    public static String solution(int n, String str) {
        String[] strs = new String[n];
        char[] ans = new char[n];
        for(int i=0; i<n; i++) {
            strs[i] = str.substring(7 * i, (7 * i) + 7);
            strs[i] = strs[i].replace('#', '1');
            strs[i] = strs[i].replace('*', '0');
            int num = Integer.parseInt(strs[i], 2);
            ans[i] = (char)num;
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
    }
}
