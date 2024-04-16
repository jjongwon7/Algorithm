import java.util.*;

class Solution {
    
    static int[] dist;
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        dist = new int[n+1]; // 노드 간 거리
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        for(int i=0; i<n+1; i++) {
            nodes.add(new ArrayList<>());
        }
        
        // 인접리스트 초기화
        for(int i=0; i<edge.length; i++) {
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            
            nodes.get(node1).add(node2);
            nodes.get(node2).add(node1);
        }
        
        // 거리 탐색
        dfs(1);
        
        int maxDist = 0;
        for(int i=2; i<=n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        for(int i=2; i<=n; i++) {
            if(maxDist == dist[i]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int startNode) {   
        for(int adNode : nodes.get(startNode)) {
            if(dist[adNode] > dist[startNode] + 1) {
                dist[adNode] = dist[startNode] + 1;
                dfs(adNode);
            }
        }
    }
}