import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 큐 초기화
        for(int i=0; i<bridge_length; i++) {
            queue.offer(-1);
        }
        
        int curWeight = 0;
        int passCnt = 0;
        int lastIdx = -1;
        
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            
            if(idx != -1) {
                passCnt++;
                curWeight -= truck_weights[idx];
            }
            
            if(lastIdx + 1 < truck_weights.length) {
                int nextWeight = curWeight + truck_weights[lastIdx + 1];
                
                if(nextWeight <= weight) {
                    queue.offer(++lastIdx);
                    curWeight = nextWeight;
                }
                else {
                    queue.offer(-1);
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}