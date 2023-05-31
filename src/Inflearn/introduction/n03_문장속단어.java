package Inflearn.introduction;

import java.util.Scanner;

public class n03_문장속단어 {
    public static String solution(String str) {
        String ans = "";
        int max = Integer.MIN_VALUE;
        int pos = 0;
        while ((pos = str.indexOf(' ')) != -1) {
            String cur = str.substring(0, pos);
            if (max < pos) {
                max = pos;
                ans = cur;
            }
            str = str.substring(pos + 1);
        }
        if (max < str.length()) {
            ans = str;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
//    public static String solution(String str) {
//        String[] strings = str.split(" ");
//        int max = 0;
//        String ans = "";
//        for(String cur : strings) {
//            if(max < cur.length()) {
//                max = cur.length();
//                ans = cur;
//            }
//        }
//        return ans;
//    }