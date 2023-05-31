package Inflearn.introduction;

import java.util.Scanner;

public class n06_중복문자제거 {
    public static String solution(String str) {
        String ans = "";
        boolean[] alp = new boolean[26];
        for(char c : str.toCharArray()) {
            if(!alp[c-'a']) {
                ans += c;
                alp[c - 'a'] = true;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
