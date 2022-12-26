package Inflearn;

import java.util.Scanner;

public class n02_대소문자변환 {
    public static String solution(String str) {
        char[] n = new char[str.length()];
        int i = 0;
        for (char c : str.toCharArray()) {
            if(c == Character.toUpperCase(c))
                n[i] = Character.toLowerCase(c);
            else
                n[i] = Character.toUpperCase(c);
            i++;

        }

        String ans = String.valueOf(n);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
