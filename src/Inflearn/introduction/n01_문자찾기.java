package Inflearn.introduction;

import java.util.Scanner;

public class n01_문자찾기 {
    public static int solution(String str, char t) {
        int ans = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char c : str.toCharArray()) {
            if(t == c)
                ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        char c;
        str = sc.nextLine();
        c = sc.next().charAt(0);
        System.out.println(solution(str, c));
    }
}
