import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][];
        
        for(int i=0; i<n; i++) {
            arr[i] = new int[i+1];
        }
        
        int direction = 0;
        int row = -1, col = 0;
        int value = 0;
        for(int i=n; i>=1; i--) {
            for(int j=0; j<i; j++) {
                if(direction % 3 == 0) { // 아래 진행
                    arr[++row][col] = ++value;
                } else if(direction % 3 == 1) { // 오른쪽 진행
                    arr[row][++col] = ++value;
                } else { // 왼쪽 위 진행
                    arr[--row][--col] = ++value;
                }    
            }
            
            direction++;
        }
        
        List<Integer> ansList = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<i+1; j++) {
                ansList.add(arr[i][j]);
            }
        }
        
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}