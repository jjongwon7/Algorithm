package Inflearn;

import java.util.Scanner;

public class n11_문자열압축 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            int cnt=1;
            for(int j=i+1; j<str.length(); j++) {
                if(str.charAt(j) == str.charAt(i)) {
                    cnt++;
                    i++;
                    continue;
                }
                else
                    break;
            }
            if(cnt!=1)
                sb.append(str.charAt(i)).append(cnt);
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
