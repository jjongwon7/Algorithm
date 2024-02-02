import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static int[] trustScoreArr;
    public static ArrayList<ArrayList<Integer>> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        nodes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.get(a).add(b);
        }

        trustScoreArr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int maxTrust = 0;

        for (int i = 1; i <= n; i++) {
            maxTrust = Math.max(trustScoreArr[i], maxTrust);
        }

        for (int i = 1; i <= n; i++) {
            if (maxTrust == trustScoreArr[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);

    }

    public static void bfs (int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            ArrayList<Integer> arrayList = nodes.get(cur);

            for (Integer next : arrayList) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    trustScoreArr[next]++;
                }
            }
        }
    }
}