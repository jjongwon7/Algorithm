package Inflearn;

import java.util.Scanner;

public class n03_문장속단어 {
    public static String solution(String str) {
        String[] strings = str.split(" ");
        int max = 0;
        String ans = "";
        for(int i=0; i<strings.length; i++) {
            if(max < strings[i].length()) {
                max = strings[i].length();
                ans = strings[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
