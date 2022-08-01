package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int A = 0, B = 0, min = 0, gcd = 0;
        StringTokenizer st;
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            min = Math.min(A, B);
            for(int j=1; j<=min; j++)
                if((A % j) == 0 && (B % j) == 0)
                    gcd = j;
            sb.append((A * B) / gcd).append('\n');
        }
        System.out.println(sb);
    }
}
