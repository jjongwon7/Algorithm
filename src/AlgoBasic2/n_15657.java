package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_15657 {
    static int n, m;
    static int[] arr, ans;
    static StringBuilder sb;

    public static void DFS(int L, int pre) {
        if (L == m) {
            for (int i : ans) {
                sb.append(i + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
                if (pre <= arr[i]) {
                    ans[L] = arr[i];
                    DFS(L + 1, arr[i]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        ans = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0, 0);
        System.out.println(sb);
    }
}
