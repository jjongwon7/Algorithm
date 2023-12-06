import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int curVal = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > curVal) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = curVal;
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (n - i) * arr[i];
        }

        System.out.println(sum);
    }
}