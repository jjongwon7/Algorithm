package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while (n >= b) {
            arrayList.add(n % b);
            n = n / b;
        }
        arrayList.add(n);
        Collections.reverse(arrayList);
        for (int i : arrayList) {
            if (i > 9) {
                sb.append((char)(i - 10 + 'A'));
            } else {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
