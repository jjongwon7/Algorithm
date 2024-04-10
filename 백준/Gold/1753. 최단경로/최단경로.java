import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점의 개수
        int e = Integer.parseInt(st.nextToken()); // 간선의 개수
        int startV = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> arrayLists = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            arrayLists.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발 노드
            int end = Integer.parseInt(st.nextToken()); // 도착 노드
            int w = Integer.parseInt(st.nextToken()); // 가중치

            arrayLists.get(start).add(new Node(end, w));
        }        int[] dist = new int[v + 1];
        boolean[] visited = new boolean[v + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startV] = 0;

        // 다익스트라 알고리즘 (음의 가중치가 없으므로, 적용 가능)
        for (int i = 0; i < v; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            // 방문하지 않은 노드 중 최소 길이를 탐색한다.
            for (int j = 1; j <= v; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }

            // 현재 최소 길이를 지닌 노드를 방문한다.
            visited[nodeIdx] = true;

            // 방문한 노드 인근 dist 초기화한다.
            for (Node node : arrayLists.get(nodeIdx)) {
                int endNode = node.v;
                int w = node.w;
                if (dist[endNode] > dist[nodeIdx] + w) {
                    dist[endNode] = dist[nodeIdx] + w;
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static class Node {
        int v; // 도착 노드
        int w; // 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}

