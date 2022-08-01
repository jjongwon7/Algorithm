package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";

        while((str = br.readLine()) != null) {
            int lowercnt = 0, uppercnt = 0, numcnt = 0, blankcnt = 0;
            for(int i=0; i<str.length(); i++) {
                if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                    lowercnt++;
                else if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                    uppercnt++;
                else if('0' <= str.charAt(i) && str.charAt(i) <= '9')
                    numcnt++;
                else if(' ' == str.charAt(i))
                    blankcnt++;
            }
            sb.append(lowercnt).append(" ").append(uppercnt).append(" ").append(numcnt).append(" ").append(blankcnt).append("\n");
        }
        System.out.println(sb);


    }
}
