package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        sb.append(sum);
        System.out.println(sb);
    }
}
