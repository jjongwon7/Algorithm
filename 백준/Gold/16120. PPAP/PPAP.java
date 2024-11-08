import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] chars = br.readLine().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'A') {
                // A인 경우 스택의 P를 2개씩 지움
                // 이때, A 뒤에 P가 오는지, A로 끝나는 것은 아닌지 체크
                if (stack.size() >= 2 && i != chars.length - 1 && chars[i+1] == 'P') {
                    stack.pop();
                    stack.pop();
                } else {
                    System.out.println("NP");
                    return;
                }
            } 
            // P는 스택에 계속 추가
            else {
                stack.push(c);
            }
        }

        // P가 하나만 남아 있어야 함.
        if (stack.size() == 1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}