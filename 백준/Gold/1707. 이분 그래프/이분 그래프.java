import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static boolean[] visited;
    public static int[] check;
    public static boolean isPossible;
    public static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");

            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);

            visited = new boolean[v + 1];
            check = new int[v + 1];
            isPossible = true;
            nodes = new ArrayList[v + 1];

            for (int j = 1; j <= v; j++) {
                nodes[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < e; j++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                nodes[a].add(b);
                nodes[b].add(a);
            }

            for (int j = 1; j <= v; j++) {
                dfs(j);
                if (!isPossible) {
                    break;
                }
            }

            if (isPossible) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dfs (int start) {
        visited[start] = true;

        for (Integer next : nodes[start]) {
            if (!visited[next]) {
                check[next] = (check[start] + 1) % 2;
                dfs(next);
            } else {
                if (check[start] == check[next]) {
                    isPossible = false;
                    return;
                }
            }
        }
    }
}