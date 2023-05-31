package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class n_15666 {
    static int n, m;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int[] rlt, arr;

    public static void DFS(int L, int pre) {
        if (L == m) {
            StringBuilder sb2 = new StringBuilder();
            for (int i : rlt) {
                sb2.append(i + " ");
            }
            if (!ans.contains(sb2.toString())) {
                ans.add(sb2.toString());
                sb.append(sb2).append("\n");
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i] >= pre) {
                    rlt[L] = arr[i];
                    DFS(L + 1, arr[i]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        rlt = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0, 0);
        System.out.println(sb);
    }
}
