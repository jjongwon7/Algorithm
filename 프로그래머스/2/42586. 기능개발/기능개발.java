import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> prQueue = new LinkedList<>();
        int pullCnt = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        while(pullCnt < progresses.length) {
            // 작업 수행
            for(int i=pullCnt; i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            // 완료된 작업 확인
            for(int i=pullCnt; i<progresses.length; i++) {
                if(progresses[i] >= 100) {
                    prQueue.offer(i);
                }
                else {
                    break;
                }
            }
            
            // pull
            if(!prQueue.isEmpty()) {
                arrayList.add(prQueue.size());    
                pullCnt += prQueue.size();
                // clear
                prQueue.clear();
            }
        }
        
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}