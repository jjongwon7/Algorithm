package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class n36_올바른괄호 {
//    public static String solution(String str) {
//        Stack<Character> stack = new Stack<>();
//        int flag = 0;
//        int size;
//        for(char c : str.toCharArray()) {
//            stack.push(c);
//        }
//        size = stack.size();
//        for(int i=0; i<size; i++) {
//            if(stack.pop() == '(') {
//                flag++;
//            }
//            else
//                flag--;
//            if(flag == 1) {
//                return "NO";
//            }
//        }
//        if(flag == 0)
//            return "YES";
//        else
//            return "NO";
//    }

    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(')
                stack.push(c);
            else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    return "NO";
            }
        }
        if(stack.isEmpty())
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
