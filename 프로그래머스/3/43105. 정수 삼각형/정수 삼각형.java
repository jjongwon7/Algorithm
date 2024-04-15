class Solution {
    
    static int[][] mem;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        mem = new int[triangle.length][];
        
        for(int i=0; i<triangle.length; i++) {
            mem[i] = new int[triangle[i].length];
        }
        
        mem[0][0] = triangle[0][0];
        
        for(int i=0; i<triangle.length-1; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                // 왼쪽 이동
                mem[i+1][j] = Math.max(mem[i+1][j], mem[i][j] + triangle[i+1][j]);
                // 오른쪽 이동
                mem[i+1][j+1] = Math.max(mem[i+1][j+1], mem[i][j] + triangle[i+1][j+1]);
            }
        }
        
        for(int i=0; i<triangle[triangle.length-1].length; i++) {
            answer = Math.max(answer, mem[triangle.length-1][i]);       
        }
        return answer;
    }
    
    
}