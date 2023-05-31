package Inflearn.introduction;

import java.util.Scanner;

public class n05_특정문자뒤집기 {
    public static String solution(String str) {
        int lt = 0;
        int rt = str.length()-1;
        char[] strs = str.toCharArray();
        while(lt<rt) {
            if(!Character.isAlphabetic(strs[lt])) {
                lt++;
                continue;
            }
            if(!Character.isAlphabetic(strs[rt])) {
                rt--;
                continue;
            }
            char tmp = strs[lt];
            strs[lt] = strs[rt];
            strs[rt] = tmp;
            lt++;
            rt--;
        }
        return String.valueOf(strs);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
