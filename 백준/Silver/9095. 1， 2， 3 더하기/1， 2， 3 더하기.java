import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N = 0;
        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N+1];
            sb.append(cal(N, 0)).append("\n");
        }
        System.out.println(sb);
    }
    static int cal(int N, int rlt) {
        if(rlt == N)
            return 1;
        if(rlt > N)
            return 0;
        return cal(N, rlt+1) + cal(N, rlt+2) + cal(N, rlt+3);
    }
}