import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {                
                if(computers[i][j] == 1) {
                    union(i, j, n);    
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(find(i));
            System.out.println(find(i));
        }
        
        return set.size();
    }
    
    public void union(int x, int y, int n) {
        int px = find(x);
        int py = find(y);
        
        parent[y] = px;
        
        for(int i=0; i<n; i++) {
            if(parent[i] == py) {
                parent[i] = px;
            }
        }
    }
    
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
}