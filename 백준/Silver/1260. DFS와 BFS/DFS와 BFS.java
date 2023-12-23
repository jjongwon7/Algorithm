import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 에지 개수
        int v = Integer.parseInt(st.nextToken()); // 노드 번호

        list = new ArrayList[n + 1];


        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n + 1];
        dfs(v, visited, sb);
        System.out.println(sb);

        sb = new StringBuilder();
        visited = new boolean[n + 1];
        bfs(v, visited, sb);
        System.out.println(sb);
    }

    public static void dfs(int start, boolean[] visited, StringBuilder sb) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (Integer end : list[start]) {
            if (!visited[end]) {
                dfs(end, visited, sb);
            }
        }
    }

    public static void bfs(int start, boolean[] visited, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    sb.append(next).append(" ");
                }
            }
        }
    }
}