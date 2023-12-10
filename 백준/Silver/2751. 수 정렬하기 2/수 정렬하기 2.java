import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, tmp, 0, n - 1);

        for (int i : arr) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);

            int leftStart = start;
            int rightStart = mid + 1;
            int idx = leftStart;

            while (leftStart <= mid || rightStart <= end) {
                if (rightStart > end || (leftStart <= mid && arr[leftStart] < arr[rightStart])) {
                    tmp[idx++] = arr[leftStart++];
                } else {
                    tmp[idx++] = arr[rightStart++];
                }
            }

            for (int i = start; i <= end; i++) {
                arr[i] = tmp[i];
            }
        }
    }
}