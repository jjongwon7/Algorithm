package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n_9613 {
    static long sum;
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < t; i++) {
            sum = 0;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arrayList = new ArrayList<>();

            while(st.hasMoreTokens()) {
                arrayList.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arrayList);
            for (int j = 0; j < arrayList.size(); j++) {
                for (int k = j + 1; k < arrayList.size(); k++) {
                    sum += gcd(arrayList.get(j), arrayList.get(k));
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
