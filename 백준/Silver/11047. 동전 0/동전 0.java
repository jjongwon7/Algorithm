import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전 종류
        int k = Integer.parseInt(st.nextToken()); // 가격의 합
        int[] arr = new int[n];
        // k로 만들기 위한 동전 개수의 최솟값?

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        greedy(arr, n, k);
    }

    public static void greedy(int[] arr, int n, int k) {
        int sum = 0;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (sum + arr[i] > k) {
                continue;
            } else {
                while (sum + arr[i] <= k) {
                    sum += arr[i];
                    count++;
                }

                if (sum == k) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}