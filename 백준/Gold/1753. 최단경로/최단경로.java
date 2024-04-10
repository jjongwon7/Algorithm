import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
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
        }

        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startV] = 0;

        // 다익스트라 알고리즘 (음의 가중치가 없으므로, 적용 가능)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startV, dist[startV]));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curV = curNode.v;
            int curW = curNode.w;

            // 우선순위 큐에 넣다보면, (2, 12), (2, 11) 처럼 도중에 최소 길이가 갱신되는 경우가 있음.
            // 이런 경우는 고려할 필요 없으니, continue
            if (curW > dist[curV]) {
                continue;
            }

            // 연결된 간선 순회하며, 갱신할 수 있는 것들은 갱신하고 우선순위 큐에 offer
            for (Node node : arrayLists.get(curV)) {
                if (dist[node.v] > curW + node.w) {
                    dist[node.v] = curW + node.w;
                    pq.offer(new Node(node.v, dist[node.v]));
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

    static class Node implements Comparable<Node> {
        int v; // 도착 노드
        int w; // 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
}

