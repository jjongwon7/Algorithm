package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        char[] charArray = n.toCharArray();
        int sum = 0;
        for (int i = n.length() - 1, j = 0; i >= 0; i--, j++) {
            int cur;
            if (Character.isAlphabetic(charArray[i])) {
                cur = charArray[i] - 'A' + 10;
                sum += Math.pow(b, j) * cur;
            } else {
                cur = charArray[i] - '0';
                sum += Math.pow(b, j) * cur;
            }
        }
        System.out.println(sum);
    }
}
