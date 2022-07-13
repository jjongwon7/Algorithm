package AlgoBasic1;

import java.util.Scanner;
import java.util.Stack;

public class n_9093 {
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++) {
            String str;
            str = sc.nextLine();
            String[] strArr = str.split(" ");
            prt(strArr);
        }
        System.out.println(sb);
    }

    static void prt(String[] strArr) {
        for(int i=0; i< strArr.length; i++) {
            for(int j=0; j<strArr[i].length();j++) {
                stack.push(strArr[i].charAt(j));
            }
            for(int j=0; j<strArr[i].length();j++) {
                char c = stack.pop();
                sb.append(c);
            }
            if(i < (strArr.length - 1))
                sb.append(" ");
            else if(i == (strArr.length - 1))
                sb.append("\n");
        }
    }
}
