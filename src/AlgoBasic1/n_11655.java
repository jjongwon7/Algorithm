package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            if('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                if(str.charAt(i) > 'z'-13)
                    sb.append((char)('a' + (str.charAt(i) + 13 - 'z') - 1));
                else
                    sb.append((char)(str.charAt(i) + 13));
            }
            else if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                if(str.charAt(i) > 'Z'-13)
                    sb.append((char)('A' + (str.charAt(i) + 13 - 'Z') - 1));
                else
                    sb.append((char)(str.charAt(i) + 13));
            else
                sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
}
