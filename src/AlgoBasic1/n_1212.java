package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            String tmp = Integer.toBinaryString(str.charAt(i) - '0');
            if (i > 0) {
                while (tmp.length() < 3) {
                    tmp = "0" + tmp;
                }
            }
            sb.append(tmp);
        }
        System.out.println(sb);
    }
}
