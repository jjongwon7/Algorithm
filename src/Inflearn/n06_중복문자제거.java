package Inflearn;

import java.util.Scanner;

public class n06_중복문자제거 {
    public static String solution(String str) {
        String ans = "";
        int[] alp = new int[26];
        for(char c : str.toCharArray()) {
            if(alp[c-'a'] == 0) {
                ans = ans + c;
            }
            alp[c-'a']++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
