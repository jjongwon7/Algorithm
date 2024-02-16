import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] leftMax = new int[n + 1];
        int[] rightMax = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        leftMax[1] = arr[1];
        rightMax[n] = arr[n];

        int ans = Math.max(leftMax[1], rightMax[n]);
        for (int i = 1; i <= n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1] + arr[i]);
            ans = Math.max(ans, leftMax[i]);
        }
        for (int i = n - 1; i >= 1; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1] + arr[i]);
            ans = Math.max(ans, rightMax[i]);
        }

        for (int i = 1; i < n; i++) {
            int temp = leftMax[i - 1] + rightMax[i + 1];
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}