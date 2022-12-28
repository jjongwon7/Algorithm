package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class n40_쇠막대기 {
    public static int solution(String str) {
        Stack<Character> stack = new Stack<>();
        char tmp = ' ';
        int ans = 0;
        for(char c : str.toCharArray()) {
            if(c == ')') {
                if(tmp == '(') {
                    stack.pop();
                    ans += stack.size();
                }
                else {
                    stack.pop();
                    ans += 1;
                }
            }
            else if(c == '(')
                stack.push('(');
            tmp = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
