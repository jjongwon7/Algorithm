import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWidth = 0; // 가로
        int maxLength = 0; // 세로
        
        for(int[] size : sizes) {
            int width = size[0];
            int length = size[1];
            
            if(width < length) {
                int temp = length;
                length = width;
                width = temp;
            }
            
            maxWidth = Math.max(width, maxWidth);
            maxLength = Math.max(length, maxLength);
        }
        
        answer = maxWidth * maxLength;
        
        
        return answer;
    }
}