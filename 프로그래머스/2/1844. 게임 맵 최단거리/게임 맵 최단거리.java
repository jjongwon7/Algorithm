import java.util.*;

class Solution {
    
    static int[] dn = {-1, 0, 1, 0};
    static int[] dm = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        return bfs(new Point(0, 0), maps);
    }
    
    public static int bfs(Point startPoint, int[][] maps) {
        int nSize = maps.length;
        int mSize = maps[0].length;
        int minDist = -1;
        int dist = 1;
        boolean[][] visited = new boolean[nSize][mSize];
        Queue<Point> queue = new LinkedList<>();
        
        queue.offer(startPoint);
        visited[startPoint.n][startPoint.m] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Point curPoint = queue.poll();
                int curN = curPoint.n;
                int curM = curPoint.m;
                
                if(curN == nSize-1 && curM == mSize-1) {
                    minDist = dist;
                    break;
                }
                
                for(int j=0; j<4; j++) {
                    int nextN = curN + dn[j];
                    int nextM = curM + dm[j];
                    
                    if(nextN >= 0 && nextM >= 0 && nextN < nSize && nextM < mSize) {
                        if(maps[nextN][nextM] != 0 && !visited[nextN][nextM]) {
                            visited[nextN][nextM] = true;
                            queue.offer(new Point(nextN, nextM));
                        }
                    }
                }
            }
            dist++;
        }
        
        return minDist;
    }
    
    static class Point {
        int n;
        int m;
         
        public Point(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}