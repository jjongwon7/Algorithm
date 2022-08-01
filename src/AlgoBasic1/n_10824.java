package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sumAB = Long.parseLong(st.nextToken() + st.nextToken());
        long sumCD = Long.parseLong(st.nextToken() + st.nextToken());
        System.out.println(sumAB + sumCD);
    }
}
