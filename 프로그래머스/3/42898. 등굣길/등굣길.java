import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] grid = new int[n+1][m+1];
        
        for(int[] puddle : puddles) {
            grid[puddle[1]][puddle[0]] = -1;
        }
        
        grid[1][1] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                
                if(grid[i][j] == -1) {
                    grid[i][j] = 0;
                    continue;
                }
                
                grid[i][j] = grid[i-1][j] % 1_000_000_007 + grid[i][j-1] % 1_000_000_007;
            }
        }
        return grid[n][m] % 1_000_000_007;
    }
}