import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = (long)times[0];
        long right = (long)times[times.length-1] * n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            boolean flag = false;
            for(int i=0; i<times.length; i++) {
                cnt += mid / times[i];
                
                if(cnt >= n) {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                right = mid - 1;
                answer = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}