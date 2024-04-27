import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] mem = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                mem[1] = 1;
            } else if (i == 2) {
                mem[2] = 2;
            } else {
                mem[i] = mem[i - 1] % 10007 + mem[i - 2] % 10007;
                mem[i] %= 10007;
            }
        }

        System.out.println(mem[n]);
    }
}