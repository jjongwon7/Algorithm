import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            visited = new boolean[k];
            List<Integer> set = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            dfs(0, set, new int[6], -1);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int depth, List<Integer> set, int[] ans, int lastIdx) {
        if (depth == 6) {
            for (int num : ans) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = depth; i < set.size(); i++) {
            if (set.size() - i < 6 - depth) {
                break;
            }

            if (visited[i]) {
                continue;
            }

            if (lastIdx > i) {
                continue;
            }

            ans[depth] = set.get(i);
            visited[i] = true;
            dfs(depth + 1, set, ans, Math.max(lastIdx, i));
            visited[i] = false;
        }
    }
}