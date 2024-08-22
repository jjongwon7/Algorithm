import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        String str = br.readLine();

        for (char c : str.toCharArray()) {
            int i = Character.getNumericValue(c);

            arr[i]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int cnt = arr[i];

            if (i == 6) {
                cnt = (int) Math.ceil((double) (cnt + arr[9]) / 2);
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}