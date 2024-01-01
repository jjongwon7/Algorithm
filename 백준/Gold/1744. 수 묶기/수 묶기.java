import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int posCnt = 0;
        int sum = 0;
        int[] arr = new int[n];
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (arr[i] > 0) {
                posCnt++;
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - posCnt; i += 2) {
            if (i + 1 == arr.length - posCnt) {
                break;
            }

            sum += arr[i] * arr[i + 1];
            check[i] = check[i + 1] = true;
        }

        for (int i = n - 1; i >= (arr.length - posCnt); i -= 2) {
            if (i - 1 < 0) {
                break;
            }

            if (arr[i] * arr[i - 1] > arr[i] + arr[i - 1]) {
                sum += arr[i] * arr[i - 1];
                check[i] = check[i - 1] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                sum += arr[i];
            }
        }

        System.out.println(sum);
    }
}