import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[n + 1];
        Arrays.fill(mem, Integer.MAX_VALUE);

        mem[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0) {
                mem[i] = Math.min(mem[i], mem[i / 3]);
            }
            if (i % 2 == 0) {
                mem[i] = Math.min(mem[i], mem[i / 2]);
            }
            mem[i] = Math.min(mem[i], mem[i - 1]);
            mem[i]++;
        }

        System.out.println(mem[n]);
    }
}