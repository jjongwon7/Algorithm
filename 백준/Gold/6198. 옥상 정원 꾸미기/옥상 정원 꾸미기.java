import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        long[] counts = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            long cnt = 0;

            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                cnt += counts[stack.pop()] + 1;
            }

            counts[i] = cnt;
            stack.push(i);
        }

        System.out.println(Arrays.stream(counts).sum());
    }
}
