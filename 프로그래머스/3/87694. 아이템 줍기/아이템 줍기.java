import java.util.*;

class Solution {

    static boolean[][] visited = new boolean[101][101];
    static int[][] movable = new int[101][101]; // -1: 이동 불가, 0: 아직 판단 X, 1: 이동 가능
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    // rectangle => int[][4] : 좌하단x, y / 우상단 x, y
    // characterX, Y => 초기 캐릭터 위치
    // itemX, Y => 아이템의 위치
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2; // 초기 캐릭터 위치
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for(int i=0; i<rectangle.length; i++) {
            for(int j=0; j<4; j++) {
                rectangle[i][j] *= 2;
            }
            
            for(int x=rectangle[i][0]; x <= rectangle[i][2]; x++) {
                for(int y=rectangle[i][1]; y<=rectangle[i][3]; y++) {
                    movable[y][x] = ((x == rectangle[i][0]) || (x == rectangle[i][2]) || (y == rectangle[i][1] || y == rectangle[i][3])) && (movable[y][x] == 0 || movable[y][x] == 1) ? 1 : -1;
                }
            }
        }
        
        return bfs(characterX, characterY, itemX, itemY);
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Point> queue = new LinkedList<>();
        visited[characterY][characterX] = true;
        queue.offer(new Point(characterX, characterY));
        
        int answer = 0;
        
        while(!queue.isEmpty()) {
            answer++;
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Point point = queue.poll();
                
                for(int j=0; j<4; j++) {
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];
                    
                    if(nx == itemX && ny == itemY) {
                        return answer / 2;
                    }
                    
                    if(nx >= 2 && ny >= 2 && nx <= 100 && ny <= 100 && movable[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        
        return -1;
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}