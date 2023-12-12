import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int maxSize = Integer.MIN_VALUE;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            maxSize = Math.max(input.length(), maxSize);
            arr[i] = Integer.parseInt(input);
        }

        radixSort(arr, maxSize);

        for (int i : arr) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void radixSort(int[] arr, int maxSize) {
        int[] output = new int[arr.length];
        int jarisu = 1;
        int count = 0;

        while (count != maxSize) {
            int[] bucket = new int[10];

            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / jarisu) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / jarisu) % 10] - 1] = arr[i];
                bucket[(arr[i] / jarisu) % 10]--;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
            jarisu *= 10;
            count++;
        }
    }
}