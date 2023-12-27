import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] rlt = new int[N+1];
        primeNum(N, rlt);
        for(int i=M; i<=N; i++) {
            if (rlt[i] == 0 && i != 1)
                sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
    static void primeNum(int max, int[] rlt) {
        for (int i = 2; i <= max; i++) {
            if (rlt[i] == 0) {
                for (int j = i + i; j <= max; j = j + i) {
                    rlt[j] = 1;
                }
            }
        }
    }
}
