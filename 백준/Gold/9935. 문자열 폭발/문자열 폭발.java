import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Character> stack = new Stack<>();
    static String str;
    static String boomStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        boomStr = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            while (stack.size() >= boomStr.length()) {
                if (!checkBoomStr()) {
                    break;
                } else {
                    for (int j = 0; j < boomStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }
    }

    public static boolean checkBoomStr() {
        boolean isBoomStr = true;
        int stackSize = stack.size();

        for (int i = boomStr.length() - 1; i >= 0; i--) {
            if (stack.get(stackSize - i - 1) != boomStr.charAt(boomStr.length() - i - 1)) {
                isBoomStr = false;
                break;
            }
        }

        return isBoomStr;
    }
}