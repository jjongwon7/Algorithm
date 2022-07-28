package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class n_17299 {
    static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[MAX];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        for (int i = 0; i < N; i++) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && (cnt[arr[i]] > cnt[arr[stack.peek()]]))
                    arr[stack.pop()] = arr[i];
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
