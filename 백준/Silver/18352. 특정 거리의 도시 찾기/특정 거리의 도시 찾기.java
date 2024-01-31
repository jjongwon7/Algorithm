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
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시의 정보

        visited = new boolean[n + 1];

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            nodes.add(arrayList);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes.get(start).add(end);
        }

        List<Integer> ansList = bfs(x, k, 0, nodes);

        if (ansList.isEmpty()) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();

            Collections.sort(ansList);
            for (Integer ans : ansList) {
                sb.append(ans).append("\n");
            }
            System.out.println(sb);
        }

    }

    public static List<Integer> bfs(int start, int k, int depth, ArrayList<ArrayList<Integer>> nodes) {
        ArrayList<Integer> ansList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            if (depth == k) {
                for (Integer ans : queue) {
                    ansList.add(ans);
                }

                break;
            }

            int size = queue.size();

            for (int cur = 0; cur < size; cur++) {
                for (Integer next : nodes.get(queue.poll())) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }

            depth++;
        }

        return ansList;
    }
}