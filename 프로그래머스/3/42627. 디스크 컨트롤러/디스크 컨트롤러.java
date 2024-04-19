import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int curTime = 0;
        int endTime = 0;
        int ans = 0;
        int waitIdx = 0;
        int cnt = 0;
        boolean flag = true;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Work> workPQ = new PriorityQueue<>((o1, o2) -> o1.workTime - o2.workTime);
        
        while(cnt < jobs.length) {
            while(waitIdx < jobs.length && jobs[waitIdx][0] <= endTime) {
                workPQ.offer(new Work(jobs[waitIdx][0], jobs[waitIdx++][1]));
            }
            // 2. 작업큐에 넣은 작업 중 소요시간이 가장 짧은 작업을 실행한다.
            if(!workPQ.isEmpty()) {
                Work work = workPQ.poll();
                ans += (endTime - work.request + work.workTime);
                endTime += work.workTime;
                cnt++;
            }
            // 3. 현재 실행 가능한 작업이 없다면, 시간을 증가시킨다.
            else {
                endTime = jobs[waitIdx][0];
            }
        }
        
        return (ans) / jobs.length;
    }
    
    static class Work implements Comparable<Work> {
        int request;
        int workTime;
        
        public Work(int request, int workTime) {
            this.request = request;
            this.workTime = workTime;
        }
        
        @Override
        public int compareTo(Work w) {
            return this.workTime - w.workTime;
        }
    }
}