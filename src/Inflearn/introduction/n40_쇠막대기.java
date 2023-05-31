package Inflearn.introduction;

import java.util.Scanner;
import java.util.Stack;

public class n40_쇠막대기 {
    public static int solution(String str) {
        Stack<Character> stack = new Stack<>();
        char pre = ' ';
        int ans = 0;
        for(char c : str.toCharArray()) {
            // ')'가 들어온 경우
            if(c == ')') {
                // 레이저인 경우
                if(pre == '(') {
                    stack.pop();
                    ans += stack.size();
                }
                // 막대기의 끝점인 경우
                else {
                    stack.pop();
                    ans += 1;
                }
            }
            // '('가 들어온 경우
            else if(c == '(')
                stack.push('(');
            pre = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
