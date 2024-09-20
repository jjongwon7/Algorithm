import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Work> pQ = new PriorityQueue<>();
        int clearCnt = 0;
        int curTime = 0;
        int nextIdx = 0;
        int sum = 0;
        
        while(clearCnt < jobs.length) {
            while(nextIdx < jobs.length && jobs[nextIdx][0] <= curTime) {
                pQ.offer(new Work(jobs[nextIdx][0], jobs[nextIdx++][1]));
            }
            
            if(pQ.isEmpty()) {
                curTime++;
                continue;
            }
            
            Work work = pQ.poll();
            sum += (curTime + work.workTime - work.requestTime);
            curTime += work.workTime;
            clearCnt++;
        }
        
        return sum / jobs.length;
    }
    
    public class Work implements Comparable<Work> {
        int requestTime;
        int workTime;
        
        public Work (int requestTime, int workTime) {
            this.requestTime = requestTime;
            this.workTime = workTime;
        }
        
        @Override
        public int compareTo(Work w) {
            return this.workTime - w.workTime;
        }
    }
}