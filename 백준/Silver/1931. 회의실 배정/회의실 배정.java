import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int preEnd = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (preEnd <= arr[i][0]) {
                cnt++;
                preEnd = arr[i][1];
            }
        }

        System.out.println(cnt);
    }
}