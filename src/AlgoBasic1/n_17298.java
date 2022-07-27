package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class n_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int [N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            if (!stack.isEmpty()) {
                if (arr[i] > arr[stack.peek()]) {
                    while (!stack.isEmpty() && arr[i] > arr[stack.peek()])
                        arr[stack.pop()] = arr[i];
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
            arr[stack.pop()] = -1;

        for(int i=0; i<N; i++)
            sb.append(arr[i]).append(" ");

        System.out.println(sb);
    }
}
