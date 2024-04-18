import java.io.*;
import java.util.*;

class Solution {
    
    static int min = Integer.MAX_VALUE;
    
    public static int solution(int N, int number) {
        dp(N, number, 0, 0);
        
        int answer = -1;
        
        if(min != Integer.MAX_VALUE) {
            answer = min;
        }
        
        return answer;
    }
    public static void dp(int n, int number, int preValue, int cnt) {
        if(cnt > 8) {
            return;
        }

        if (preValue == number) {
            min = Math.min(min, cnt);
            return;
        }
        
        int index = 0;
        for(int i=1; i<9; i++) {
            index = 10 * index + n;
            
            dp(n, number, preValue + index, cnt+i);
            dp(n, number, preValue * index, cnt+i);
            dp(n, number, preValue - index, cnt+i);
            dp(n, number, preValue / index, cnt+i);         
        }
    }
}