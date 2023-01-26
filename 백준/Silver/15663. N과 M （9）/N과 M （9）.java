import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] ans;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static boolean[] ch = new boolean[10001];
    static int[] cnt = new int[10001];
    static StringBuilder sb;

    public static void DFS(int L) {
        if (L == m) {
            for (int i : ans) {
                sb.append(i + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                int val = arrayList.get(i);
                if (cnt[val] != 0) {
                    ans[L] = val;
                    cnt[val]--;
                    DFS(L + 1);
                    cnt[val]++;
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
        ans = new int[m];
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (!ch[input]) {
                arrayList.add(input);
                ch[input] = true;
            }
            cnt[input]++;
        }
        Collections.sort(arrayList);
        DFS(0);
        System.out.println(sb);
    }
}
