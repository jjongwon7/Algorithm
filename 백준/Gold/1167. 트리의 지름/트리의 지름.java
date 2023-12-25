import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<MovableNode>[] list;
    static boolean[] visited;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        distance = new long[v + 1];

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        // setting values
        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());

            while (true) {
                int node = Integer.parseInt(st.nextToken());

                if (node == -1) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());
                list[startNode].add(new MovableNode(node, weight));
            }
        }

        bfs(1);

        long max = Integer.MIN_VALUE;
        int maxNode = 0;
        for (int i = 1; i <= v; i++) {
            if (max < distance[i]) {
                maxNode = i;
                max = distance[i];
            }
        }

        visited = new boolean[v + 1];
        distance = new long[v + 1];

        bfs(maxNode);

        long ans = Arrays.stream(distance).max().getAsLong();
        System.out.println(ans);
    }

    public static void bfs(int startNode) {
        Queue<MovableNode> queue = new LinkedList<>();
        queue.add(new MovableNode(startNode, 0));
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            MovableNode curNode = queue.poll();

            for (MovableNode movableNode : list[curNode.node]) {
                if (!visited[movableNode.node]) {
                    queue.add(movableNode);
                    visited[movableNode.node] = true;
                    distance[movableNode.node] = distance[curNode.node] + movableNode.weight;
                }
            }
        }
    }

    static class MovableNode {
        int node;
        int weight;

        public MovableNode(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}