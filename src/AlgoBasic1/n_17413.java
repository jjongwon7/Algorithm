package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class n_17413 {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '<') {
                while(!stack.isEmpty())
                    sb.append(stack.pop());

                while(str.charAt(i) != '>') {
                    sb.append(str.charAt(i++));
                }
                sb.append(str.charAt(i));
            }
            else if (str.charAt(i) == ' ') {
                while(!stack.isEmpty())
                    sb.append(stack.pop());

                sb.append(' ');
            }
            else
                stack.push(str.charAt(i));
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb);
    }
}
