import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1, k - 1);

        System.out.println(arr[k - 1]);
    }

    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == k) {
                return;
            } else if (k < pivot) {
                quickSort(arr, start, pivot - 1, k);
            } else {
                quickSort(arr, pivot + 1, end, k);
            }
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int m = (start + end) / 2;
        swap(arr, start, m);

        int pivot = arr[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (j >= start + 1 && pivot < arr[j]) {
                j--;
            }
            while (i <= end && pivot > arr[i]) {
                i++;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }

        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }
}