package Inflearn.introduction;

import java.util.Scanner;
import java.util.Stack;

public class n39_후위식연산_postfix {
    public static int solution(String str) {
        Stack<String> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c))
                stack.push(String.valueOf(c));
            else {
                int rt = Integer.parseInt(stack.pop());
                int lt = Integer.parseInt(stack.pop());
                switch (c) {
                    case '+': stack.push(String.valueOf(lt + rt)); break;
                    case '-': stack.push(String.valueOf(lt - rt)); break;
                    case '*': stack.push(String.valueOf(lt * rt)); break;
                    case '/': stack.push(String.valueOf(lt / rt)); break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
