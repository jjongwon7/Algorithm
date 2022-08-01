package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = 0;
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int min = Math.min(A, B);
        for(int i=1; i<=min; i++) {
            if((A % i) == 0 && (B % i) == 0)
                gcd = i;
        }
        sb.append(gcd).append('\n');
        sb.append((A * B) / gcd);
        System.out.println(sb);
    }
}
