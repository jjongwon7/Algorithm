package Inflearn;

import java.util.Scanner;

public class n08_유효한팰린드롬 {
    public static String solution(String str) {
        char[] strs = str.toUpperCase().toCharArray();
        int lt = 0, rt = str.length() - 1;
        while(lt < rt) {
            if(!Character.isAlphabetic(strs[lt]))
                lt++;
            else if(!Character.isAlphabetic(strs[rt]))
                rt--;
            else
                if(strs[lt] != strs[rt])
                    return "NO";
                else {
                    lt++;
                    rt--;
                }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
