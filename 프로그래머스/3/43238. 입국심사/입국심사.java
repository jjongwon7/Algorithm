class Solution {
    public long solution(int n, int[] times) {
        int maxTime = 0;
        for(int time : times) {
            maxTime = Math.max(time, maxTime);
        }
        
        long left = 0;
        long right = (long)maxTime * n;
        long answer = 0;
        
        while(left <= right) {
            long mid = right - (right - left) / 2;
            long sum = 0;
            for(int time : times) {
                sum += mid / time;
            }
            
            if(sum >= n) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}