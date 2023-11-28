    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            int data = 1;
            int n = Integer.parseInt(br.readLine());
            int input;

            loopOut:
            for(int i=0;i<n;i++) {
                input = Integer.parseInt(br.readLine());
                while(input != 0) {
                    if (stack.isEmpty()) {
                        stack.push(data++);
                        sb.append('+').append('\n');
                    }
                    else if (stack.peek() < input) {
                        stack.push(data++);
                        sb.append('+').append('\n');
                    }
                    else if (stack.peek() == input) {
                        stack.pop();
                        input = 0;
                        sb.append('-').append('\n');
                    }
                    else if (stack.peek() > input) {
                        sb.setLength(0);
                        sb.append("NO").append('\n');
                        break loopOut;
                    }
                }
            }
            System.out.println(sb);
        }
    }
