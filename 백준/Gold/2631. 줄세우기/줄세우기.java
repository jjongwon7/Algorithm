import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(arr, n));
    }

    public static int dp(int[] arr, int n) {
        int[] mem = new int[n];
        int lisLength = 0;

        for (int i = 0; i < n; i++) {
            mem[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }

            lisLength = Math.max(lisLength, mem[i]);
        }

        return n - lisLength;
    }
}