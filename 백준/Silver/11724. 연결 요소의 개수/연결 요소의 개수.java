import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // node
        int m = Integer.parseInt(st.nextToken()); // edge

        boolean[] visit = new boolean[n + 1];
        Map<Integer, List<Integer>> movable = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            movable.put(u, movable.getOrDefault(u, new ArrayList<>()));
            movable.get(u).add(v);

            movable.put(v, movable.getOrDefault(v, new ArrayList<>()));
            movable.get(v).add(u);
        }

        int ans = 0;

        while (true) {
            int startNode = findStartNode(visit);
            if (startNode == 0) {
                break;
            } else {
                dfs(visit, movable, startNode);
            }
            ans++;
        }

        System.out.println(ans);
    }

    public static int findStartNode(boolean[] visit) {
        for (int i = 1; i < visit.length; i++) {
            if (!visit[i]) {
                return i;
            }
        }

        return 0;
    }

    public static void dfs(boolean[] visit, Map<Integer, List<Integer>> movable, int startNode) {
        visit[startNode] = true;
        List<Integer> movableNodes = movable.get(startNode);

        if (movableNodes == null || movableNodes.isEmpty()) {
            return;
        }

        for (Integer movableNode : movableNodes) {
            if (!visit[movableNode]) {
                dfs(visit, movable, movableNode);
            }
        }
    }
}