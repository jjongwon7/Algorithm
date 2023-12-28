import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int left = max;
        int right = sum;

        while (left <= right) {
            int blueRaySize = (left + right) / 2;
            int cnt = 1;
            sum = 0;

            for (int i : arr) {
                sum += i;

                if (sum > blueRaySize) {
                    sum = i;
                    cnt++;
                }
            }

            if (cnt > m) {
                left = blueRaySize + 1;
            } else {
                right = blueRaySize - 1;
            }
        }

        System.out.println(left);
    }
}