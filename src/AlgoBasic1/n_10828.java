package AlgoBasic1;

import java.util.Scanner;
import java.util.Stack;

public class n_10828 {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = s.nextInt();
        s.nextLine();
        for (int i=0; i< N ;i++) {
            String str = s.nextLine();
            String[] strArr = str.split(" ");
            switch(strArr[0])
            {
                case "push":
                    push(Integer.parseInt(strArr[1]));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push(int n) {
        stack.push(n);
    }

    static int pop() {
        if (stack.isEmpty())
            return -1;
        else {
            int tmp;
            tmp = stack.peek();
            stack.pop();
            return tmp;
        }
    }

    static int size() {
        return stack.size();
    }

    static int empty() {
        if (stack.isEmpty())
            return 1;
        else
            return 0;
    }

    static int top() {
        if (stack.isEmpty())
            return -1;
        else
            return stack.peek();
    }
}
