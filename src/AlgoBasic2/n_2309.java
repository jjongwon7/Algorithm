package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int ans = 0;
        int[] nanjang = new int[9];
        for (int i = 0; i < 9; i++) {
            nanjang[i] = Integer.parseInt(br.readLine());
            sum += nanjang[i];
        }
        Arrays.sort(nanjang);
        int i = 0, j = 0;
        for (; i < 9; i++) {
            for (j = i + 1; j < 9; j++) {
                ans = 0;
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        ans += nanjang[k];
                    }
                }
                if (ans == 100) {
                    break;
                }
            }
            if (ans == 100) {
                break;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
                sb.append(nanjang[k] + "\n");
            }
        }
        System.out.println(sb);
    }
}