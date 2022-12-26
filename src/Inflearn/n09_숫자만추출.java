package Inflearn;

import java.util.Scanner;

public class n09_숫자만추출 {
    public static int solution(String str) {
        str = str.replaceAll("[^0-9]","");
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
