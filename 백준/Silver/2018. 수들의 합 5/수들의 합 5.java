import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1 2 3 4 5 6 7 8 9 10
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        int left = 1;
        int right = 1;
        int sum = 1;
        int ans = 0;

        while (left <= right) {
            if (sum == n) {
                ans++;
                sum -= left;
                left++;
            }

            if (sum < n) {
                right++;
                sum += right;
            }

            if (sum > n) {
                sum -= left;
                left++;
            }
        }
        System.out.println(ans);
    }
}