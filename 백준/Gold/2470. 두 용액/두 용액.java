import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length - 1;
        int bestValue = Integer.MAX_VALUE;
        int[] answerArr = new int[2];

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (Math.abs(bestValue) > Math.abs(sum)) {
                bestValue = sum;
                answerArr[0] = arr[lt];
                answerArr[1] = arr[rt];
            }

            if (Math.abs(arr[lt + 1] + arr[rt]) < Math.abs(arr[lt] + arr[rt - 1])) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(answerArr[0] + " " + answerArr[1]);
    }
}