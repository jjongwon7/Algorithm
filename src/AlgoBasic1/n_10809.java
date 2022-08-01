package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] num = new int[26];
        Arrays.fill(num, -1);
        for(int i=0; i<str.length(); i++) {
            if(num[(str.charAt(i) - 'a')] == -1)
                num[(str.charAt(i) - 'a')] = i;
        }

        for(int i=0; i<26; i++)
            sb.append(num[i]).append(" ");

        System.out.println(sb);

    }
}
