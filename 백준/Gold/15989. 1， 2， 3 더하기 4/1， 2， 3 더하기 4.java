import java.io.*;
import java.util.*;

public class Main {

    static int[][] mem = new int[10001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        dp();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(mem[n][1] + mem[n][2] + mem[n][3]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dp() {
        mem[1][1] = 1;
        mem[2][1] = 1;
        mem[2][2] = 1;
        mem[3][1] = 1;
        mem[3][2] = 1;
        mem[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            mem[i][1] = mem[i-1][1];
            mem[i][2] = mem[i - 2][1] + mem[i - 2][2];
            mem[i][3] = mem[i - 3][1] + mem[i - 3][2] + mem[i - 3][3];
        }
    }
}