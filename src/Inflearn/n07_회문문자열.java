package Inflearn;

import java.util.Scanner;

public class n07_회문문자열 {
    public static String solution(String str) {
        int lt = 0, rt = str.length() - 1;
        char[] strs = str.toUpperCase().toCharArray();
        while(lt < rt) {
            if(strs[lt++] == strs[rt--])
                continue;
            else
                return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
