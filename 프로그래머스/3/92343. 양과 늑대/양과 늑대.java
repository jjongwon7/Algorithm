class Solution {
    
    static boolean[] visited;
    static int answer = 1;
    
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;        
        dfs(1, 0, info, edges);
        
        return answer;
    }
    
    public void dfs(int sheepCnt, int wolfCnt, int[] info, int[][] edges) {
        answer = Math.max(answer, sheepCnt);
        
        for(int[] edge : edges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                // 이동 가능
                if(sheepCnt - wolfCnt - info[edge[1]] > 0) {
                    visited[edge[1]] = true;
                    
                    if(info[edge[1]] == 0) {
                        dfs(sheepCnt + 1, wolfCnt, info, edges);
                    } else {
                        dfs(sheepCnt, wolfCnt + 1, info, edges);
                    }
                    
                    visited[edge[1]] = false;
                }
            }
        }
    }
}