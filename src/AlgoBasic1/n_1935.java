package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class n_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double sum = 0;
        String str = br.readLine();

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<str.length(); i++) {
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                stack.push(arr[str.charAt(i)-'A']);
            else {
                double b = stack.pop();
                double a = stack.pop();
                switch (str.charAt(i)) {
                    case '+' :
                        sum = (a + b);
                        stack.push(sum);
                        break;
                    case '-' :
                        sum = (a - b);
                        stack.push(sum);
                        break;
                    case '*' :
                        sum = (a * b);
                        stack.push(sum);
                        break;
                    case '/' :
                        sum = (a / b);
                        stack.push(sum);
                        break;
                }
            }
        }
        System.out.printf("%.2f",sum);
    }
}
