package AlgoBasic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_15655 {
    static int n, m;
    static int[] arr, ans;
    static boolean[] check;
    static StringBuilder sb;

    public static void DFS(int L, int pre) {
        if (L == m) {
            for (int i : ans) {
                sb.append(i + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == false && arr[i] > pre) {
                    check[i] = true;
                    ans[L] = arr[i];
                    DFS(L + 1, arr[i]);
                    check[i] = false;
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
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0, 0);
        System.out.println(sb);
    }
}
