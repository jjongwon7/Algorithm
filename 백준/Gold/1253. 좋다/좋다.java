import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;

        for (int k = 0; k < n; k++) {
            int left = 0;
            int right = n - 1;

            while (left < right && right < n) {
                if (arr[left] + arr[right] == arr[k]) {
                    if (left == k) {
                        left++;
                    } else if (right == k) {
                        right--;
                    } else {
                        ans++;
                        break;
                    }
                } else if (arr[left] + arr[right] < arr[k]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(ans);
    }
}