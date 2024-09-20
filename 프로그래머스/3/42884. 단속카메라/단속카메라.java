import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int prePos = -30001;
        int cnt = 0;
        
        for(int[] route : routes) {
            int st = route[0];
            int et = route[1];
            
            if(prePos >= st) {
                continue;
            }
            
            prePos = et;
            cnt++;
        }
        
        return cnt;
    }
}