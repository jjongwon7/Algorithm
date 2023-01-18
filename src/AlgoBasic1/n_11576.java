package AlgoBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num[] = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = m - 1, j = 0; i >= 0; i--, j++) {
            sum += Math.pow(a, j) * num[i];
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (sum >= b) {
            arrayList.add(sum % b);
            sum /= b;
        }
        arrayList.add(sum);
        Collections.reverse(arrayList);
        for (int i : arrayList) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
