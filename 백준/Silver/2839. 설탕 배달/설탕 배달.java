import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] mem = new int[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        mem[3] = 1;
        mem[5] = 1;

        for (int i = 6; i < 5001; i++) {
            if (mem[i - 3] != 0) {
                mem[i] = mem[i - 3] + 1;
            }
            if (mem[i - 5] != 0) {
                if (mem[i] == 0) {
                    mem[i] = mem[i - 5] + 1;
                } else {
                    mem[i] = Math.min(mem[i - 5] + 1, mem[i]);
                }
            }
        }

        if (mem[n] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(mem[n]);
        }
    }
}