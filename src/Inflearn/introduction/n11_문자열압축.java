package Inflearn.introduction;

import java.util.Scanner;

public class n11_문자열압축 {
    public static StringBuilder solution(String str) {
        StringBuilder sb = new StringBuilder();
        str = str + " ";
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                sb.append(str.charAt(i));
                if (cnt != 1) {
                    sb.append(cnt);
                    cnt = 1;
                }
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
